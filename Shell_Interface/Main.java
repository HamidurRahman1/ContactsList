package Shell_Interface;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            final Shell shell = new Shell("hr-Shell_Interface>");
            String command;
            Scanner sc = new Scanner(System.in);
            
            System.out.println(Shell.Commands());
            while(true)
            {
                System.out.print(shell.getName());
                command = sc.nextLine();
                System.out.println(shell.executeCommand(command));
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
