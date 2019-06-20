package Shell_Interface;

import java.util.LinkedList;
import java.util.List;

public class History
{
    private final List<String> history;

    public History()
    {
        history = new LinkedList <>();
    }

    public List <String> getHistory()
    {
        return history;
    }

    public void add(String command)
    {
        history.add(command);
    }
}
