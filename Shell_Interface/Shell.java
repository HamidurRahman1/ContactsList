package Shell_Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.LocalDateTime;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Shell
{
    private final ProcessBuilder processBuilder;
    private final History history;
    private final String name;
    
    private String directory;
    private String result;
    
    public Shell(final String name)
    {
        this.name = name;
        processBuilder = new ProcessBuilder();
        history = new History();
        this.directory = Paths.get("").toAbsolutePath().toString();
        processBuilder.directory(new File(this.directory));
    }
    
    public String getName()
    {
        return name;
    }
    
    public String executeCommand(String command) throws IOException, IllegalArgumentException
    {
        history.add(command);
        
        String[] args = command.split(" ");
        if(args.length == 1 && singleCommand(command))
        {
            return result;
        }
        else if(args.length == 2 && moreCommands(args))
        {
            return result;
        }
        else throw new IllegalArgumentException("Invalid command");
    }
    
    private boolean singleCommand(String command) throws IOException, IllegalAccessError
    {
        if("pwd".equalsIgnoreCase(command))
        {
            processBuilder.directory(new File(directory));
            result = directory;
            return true;
        }
        else if("cd".equalsIgnoreCase(command))
        {
            directory = System.getProperty("user.home");
            processBuilder.directory(new File(directory));
            result = processBuilder.directory().toString();
            return true;
        }
        else if("os".equalsIgnoreCase(command))
        {
            result = System.getProperty("os.name");
            return true;
        }
        else if("history".equalsIgnoreCase(command))
        {
            result = history.getHistory().toString();
            return true;
        }
        else if("env".equalsIgnoreCase(command))
        {
            StringBuilder sb = new StringBuilder();
            for(String env : System.getenv().keySet())
            {
                sb.append(env).append("=").append(System.getenv(env)).append("\n");
            }
            result = sb.toString();
            return true;
        }
        else if("!!".equalsIgnoreCase(command))
        {
            if(history.getHistory().size() <= 1)
                throw new IllegalAccessError("No previous command found");
            else
            {
                int i = history.getHistory().size()-2;
                result = executeCommand(history.getHistory().get(i));
                return true;
            }
        }
        else if("ls".equalsIgnoreCase(command))
        {
            StringBuilder sb = new StringBuilder();
            
            Stream<Path> filePathStream = Files.walk(Paths.get(directory));
            filePathStream.forEach(filePath ->
            {
                if(Files.isRegularFile(filePath))
                {
                    sb.append(filePath);
                    sb.append("\n");
                }
            });
            result = sb.toString();
            return true;
        }
        else if("exit".equalsIgnoreCase(command))
        {
            result = "Good Bye!";
            System.out.println(result);
            System.exit(0);
        }
        else if("date".equalsIgnoreCase(command))
        {
            StringBuilder sb = new StringBuilder();
            LocalDateTime d = LocalDateTime.now();
            sb.append(d.getDayOfWeek()).append(" ").append(d.getMonth())
              .append(" ").append(d.getDayOfMonth()).append(" ").append(d.getHour())
              .append(":").append(d.getMinute()).append(":").append(d.getSecond())
              .append(" ").append(d.getYear());
            result = sb.toString();
            return true;
        }
        else if("cal".equalsIgnoreCase(command))
        {
            result = process(command);
            return true;
        }
        else if("logname".equalsIgnoreCase(command))
        {
            result = process(command);
            return true;
        }
        else if("who".equalsIgnoreCase(command))
        {
            result = process(command);
            return true;
        }
        else if("users".equalsIgnoreCase(command))
        {
            result = process(command);
            return true;
        }
        else if("whoami".equalsIgnoreCase(command))
        {
            result = process(command);
            return true;
        }
        return false;
    }
    
    private boolean moreCommands(String... args) throws IOException, IllegalArgumentException
    {
        File file;
        
        if(args[0].equalsIgnoreCase("cd"))
        {
            if(args[1].equals(".."))
            {
                directory = Paths.get(directory).getParent().toAbsolutePath().toString();
                file = new File(directory);
                if(file.isDirectory())
                {
                    processBuilder.directory(file);
                    result = directory;
                    return true;
                }
            }
            file = new File(args[1]);
            if(file.isDirectory())
            {
                directory = file.getAbsolutePath();
                processBuilder.directory(new File(directory));
                result = directory;
                return true;
            }
        }
        else if(args[0].equalsIgnoreCase("mkdir"))
        {
            String newDir = determineNewDir(args);
            
            Path path = Paths.get(newDir);
            if(!Files.exists(path))
            {
                Files.createDirectories(path);
                result = path.toAbsolutePath().toString();
                return true;
            }
        }
        else if(args[0].equalsIgnoreCase("cat"))
        {
            file = new File(args[1]);
            if(file.isFile() && file.exists())
            {
                result = process(args);
                return true;
            }
        }
        else if(args[0].equalsIgnoreCase("touch"))
        {
            String newDir = determineNewDir(args);
            
            if(newDir.contains("."))
            {
                file = new File(newDir);
                file.createNewFile();
                result = file.getAbsolutePath();
                return true;
            }
            else
            {
                file = new File(newDir.concat(".txt"));
                file.createNewFile();
                result = file.getAbsolutePath();
                return true;
            }
        }
        return false;
    }
    
    private String process(String... args) throws IOException
    {
        processBuilder.command(args);
        Process process = processBuilder.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
    
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) sb.append(line).append("\n");
        br.close();
        return sb.toString();
    }
    
    private String determineNewDir(String... args)
    {
        String newDir;
        String[] a = args[1].split("/");
    
        if(a.length == 1) newDir = processBuilder.directory().getAbsolutePath().concat("/").concat(args[1]);
        else newDir = args[1];
        return newDir;
    }
    
    public static List<String> Commands()
    {
        return Arrays.asList("!!", "cal", "cat [file]", "cd", "cd ..", "cd [dir]", "date", "env",
            "exit", "history", "logname", "ls", "mkdir [dir]", "os", "pwd", "touch [file]", "users", "who", "whoami");
    }
}
