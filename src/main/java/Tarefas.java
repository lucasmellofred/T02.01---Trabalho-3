import javax.swing.*;

public class Tarefas extends JFrame {
    private JPanel painel;
    private CriaLista criaLista;
    JButton btn;

    public Tarefas(){
        setTitle("Tarefas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,400);
        configLayout();
        setVisible(true);
    }
    private void configLayout() {
        painel = new JPanel();
        GroupLayout group = new GroupLayout(painel);
        group.setAutoCreateGaps(true);
        group.setAutoCreateContainerGaps(true);

        painel.setLayout(new BoxLayout(painel,BoxLayout.Y_AXIS));
        JScrollPane scrollPanel = new JScrollPane(painel);

        painel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Caixa de Entrada"),
                                BorderFactory.createEmptyBorder(8,8,8,8)
                        ),
                        painel.getBorder()
                )
        );
        criaLista = new CriaLista();
        btn = new JButton("Criar nova tarefa");
        btn.setHorizontalTextPosition(AbstractButton.RIGHT);
        painel.add(btn);
        painel.add(Box.createVerticalStrut(20));
        popularLista();
        add(scrollPanel);
    }
    private void popularLista(){
        for(String str : criaLista.listar()){
            painel.add(ItemLista(str));
            painel.add(Box.createVerticalStrut(10));
            painel.add(Box.createHorizontalStrut(10));
        }
    }
    private JPanel ItemLista(String item){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(item);
        JCheckBox CheckBox = new JCheckBox("");
        CheckBox.setSelected(true);

        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.add(label);
        panel.add(CheckBox);
        return panel;
    }
}