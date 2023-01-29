import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Notepad extends JFrame implements ActionListener{
    
    JTextArea jta = new JTextArea();
    File containerFile;

    JMenuBar mainBar = new JMenuBar();
    JMenu jmFile = new JMenu("File");
    JMenuItem jmiNew = new JMenuItem("New");
    JMenuItem jmiOpen = new JMenuItem("Open");
    JMenuItem jmiSave = new JMenuItem("Save");
    JMenuItem jmiExit = new JMenuItem("Exit");

    JMenu jmEdit = new JMenu("Edit");
    JMenuItem jmiCut = new JMenuItem("Cut");
    JMenuItem jmiCopy = new JMenuItem("Copy");
    JMenuItem jmiPaste = new JMenuItem("Paste");

    JMenu jmHelp = new JMenu("Help");
    JMenuItem jmiHelp = new JMenuItem("About Notepad");

    JScrollPane jscPane = new JScrollPane(jta);
    Container con = getContentPane();
    JFileChooser jfc;

    public Notepad()
    {
        setTitle("Untitled--Notepad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        jscPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(jscPane);
        jta.setLineWrap(true);
        jta.setFont(new Font("Arial",Font.PLAIN,14));
        setJMenuBar(mainBar);
        mainBar.add(jmFile);
        jmFile.add(jmiNew);
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.addSeparator();
        jmFile.add(jmiExit);

        mainBar.add(jmEdit);
        jmEdit.add(jmiCut);
        jmEdit.add(jmiCopy);
        jmEdit.add(jmiPaste);

        mainBar.add(jmHelp);
        jmHelp.add(jmiHelp);

        jmiNew.addActionListener(this);
        jmiOpen.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiCut.addActionListener(this);
        jmiCopy.addActionListener(this);
        jmiPaste.addActionListener(this);
        jmiHelp.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        jfc = new JFileChooser();
         Object source = e.getSource();

         if(source == jmiNew)
           newFile();
         else
         if(source == jmiOpen)
           openFile();
         else
         if(source == jmiSave)
           saveFile();
        else
        if(source == jmiExit)
            exitFile();
        else
        if(source == jmiCut)
            cutFile();
        else
        if(source == jmiCopy)
            copyFile();
        else
        if(source == jmiPaste)
            pasteFile();
        else
        if(source == jmiHelp)
            helpFile();
    }

    public void newFile()
    {
        setTitle("Untitled.txt--Notepad");
        jta.setText("");
        containerFile = null;
    }
    public void openFile()
    {
        int returnValue = jfc.showDialog(null,"Open");

        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File fl = jfc.getSelectedFile();
                String fileName = fl.getAbsolutePath();

                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                String s;
                jta.setText("");         
                while((s = reader.readLine()) != null)
                  jta.setText(jta.getText() + s + "\r\n");
                reader.close();

                this.setTitle(fl.getName() + "--Notepad");
                containerFile = fl;
            }
            catch(Exception e){}
        }
    }
    public void saveFile()
    {
         
    }
    public void exitFile()
    {
        System.exit(ABORT);
    }
    public void cutFile()
    {

    }
    public void copyFile()
    {

    }
    public void pasteFile()
    {

    }
    public void helpFile()
    {

    }
    public static void main(String[] args)
    {
       Notepad frame = new Notepad();
       frame.setBounds(300,300,500,500);
       frame.setVisible(true);
    }
}
