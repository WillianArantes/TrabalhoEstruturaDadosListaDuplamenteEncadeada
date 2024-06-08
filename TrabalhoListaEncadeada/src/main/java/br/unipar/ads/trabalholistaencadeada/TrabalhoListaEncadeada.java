
package br.unipar.ads.trabalholistaencadeada;

import br.unipar.ads.trabalholistaencadeada.models.Cliente;
import br.unipar.ads.trabalholistaencadeada.models.Lista;
import java.util.InputMismatchException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author willh
 */
public class TrabalhoListaEncadeada {

    public static void main(String[] args)  {
        //////************dados para simular operações***********//////
        Lista<Cliente> listaClientes = new Lista<>();
        
        Cliente novoCliente01 = new Cliente();
        novoCliente01.setNome("willian");
        novoCliente01.setCodigo(1);
        
        Cliente novoCliente02 = new Cliente();
        
        novoCliente02.setNome("cleiton");
        novoCliente02.setCodigo(2);

        Cliente novoCliente03 = new Cliente();
        
        novoCliente03.setNome("jesssica");
        novoCliente03.setCodigo(3);
             
//        listaClientes.incluirNoInicio(novoCliente01);
//        listaClientes.incluirNoInicio(novoCliente03);
//        listaClientes.incluirNoFim(novoCliente02);

        //////************menu de opções***********//////
        int opcao = 0; 
        String input;
        
        input = JOptionPane.showInputDialog(
                "Informe o numero da opção desejada: "
                        + "\nOpção 1 - Cadastrar cliente"
                        + "\nOpção 2 - Excluir Cliente"
                        + "\nOpção 3 - Alterar cadastro de cliente"
                        + "\nOpção 4 - Exibir dados de cliente"
                        + "\nOpção 5 - Exibir dados de todos clientes ");
        
        opcao = Integer.parseInt(input);
        switch(opcao){
//            Gravar novos cadastros na lista;
            case 1:
                int codigo;
                String nome;
                String dtNascimento;
                String telefone;
               
                Random random = new Random();
                codigo = random.nextInt(99999);
                
                Cliente novoCliente = new Cliente();

                    nome = JOptionPane.showInputDialog("Informe o nome: ");
                    dtNascimento = JOptionPane.showInputDialog(
                            "informe a data de nascimento: Neste formato "
                                    + "dd/MM/yyyy");
                    telefone = JOptionPane.showInputDialog(
                            "informe o numero de telefone:");


                    novoCliente.setCodigo(codigo);
                    novoCliente.setNome(nome);
                    novoCliente.setDtNasimento(dtNascimento);
                    novoCliente.setTelefone(telefone);

                    JOptionPane.showMessageDialog(null, 
                            "Cadastro conluido! \n" +
                                    novoCliente.toString());
                    listaClientes.incluirNoInicio(novoCliente);

               
                break;
            case 2:
//               Excluir cadastro da lista;
                codigo = 0;
                input  = JOptionPane.showInputDialog(
                        "informe o codigo do cliente:");
                codigo = Integer.parseInt(input);
                JOptionPane.showMessageDialog(null,
                        listaClientes.excluirCliente(codigo));
                break;
            case 3:
////                Alterar os dados de um cadastro existente;
                input = JOptionPane.showInputDialog(
                        "informe o codigo do cliente:");
                codigo = Integer.parseInt(input);
                listaClientes.alterarCadastro(codigo);
                break;
            case 4:
//                Recuperar e exibir os dados de um cadastro existente;
                 input = JOptionPane.showInputDialog(
                        "informe o codigo do cliente:");
                codigo = Integer.parseInt(input);
                JOptionPane.showMessageDialog(null, 
                        listaClientes.buscarCliente(codigo));
                break;
            case 5:
//               Exibir os dados de todos os cadastros.
                JOptionPane.showMessageDialog(null, 
                        listaClientes.exibirTodosClientes());
                
                break;
                default: 
                    JOptionPane.showMessageDialog(null, 
                            "Opção invalida!");
        }
        
        
    }
}
