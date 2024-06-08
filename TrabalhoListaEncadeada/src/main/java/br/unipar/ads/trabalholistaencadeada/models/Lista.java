
package br.unipar.ads.trabalholistaencadeada.models;



import br.unipar.ads.trabalholistaencadeada.models.Exceptions.ListaVaziaException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author willh
 */@Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
public class Lista<cliente>{
    
    private Nodo<Cliente> primeiro;
    private Nodo<Cliente> ultimo;
    

  
    public void incluirNoFim(Cliente cliente){
        Nodo<Cliente> novoNodo = new Nodo<Cliente>(cliente);
        if(isEmpty()){
            primeiro = novoNodo;
            ultimo = novoNodo;
        }else{
            ultimo.setProximo(novoNodo);
            novoNodo.setAnterior(ultimo);
            ultimo = novoNodo;
        }
        
    }
    
    public void incluirNoInicio(Cliente cliente) {
        Nodo<Cliente> novoNodo = new Nodo<Cliente>(cliente);
        if(isEmpty()){
            primeiro = novoNodo;
            ultimo = novoNodo;
        }else{
            novoNodo.setProximo(primeiro);
            primeiro.setAnterior(novoNodo);
            primeiro = novoNodo;
        }
    }
    
    public Cliente excluirDoInicio()throws ListaVaziaException{
        if(isEmpty()){
            throw new ListaVaziaException();
        }
        Cliente clienteExcluido = primeiro.getCliente();
        if(primeiro == ultimo){
            primeiro = null;
            ultimo = null;
        }else{
            primeiro = primeiro.getProximo();
        }    
                    
        return clienteExcluido;
    }
    public String excluirCliente(int codigo) {
    Nodo<Cliente> noAtual = primeiro;
    Nodo<Cliente> noAnterior = null;

    while (noAtual != null) {
        if (noAtual.getCliente().getCodigo() == codigo) {
            if (noAnterior == null) {
//                se o no anterior é null, entao logo o nó atual é o primeiro da lista
                // O cliente a ser excluído está no primeiro nodo
                primeiro = noAtual.getProximo();
            } else {
                // O cliente a ser excluído está no meio ou final da lista
                noAnterior.setProximo(noAtual.getProximo());
            }
            return "Cliente excluido: " + noAtual.getCliente().toString();
        }
        //atualizado os ponteiros, para percorrer o rpoximovv valor da lista.
        noAnterior = noAtual;
        noAtual = noAtual.getProximo();
        
    }
    return "Erro não tem nenhum cliente cadastrado com este codigo!"; // Cliente não encontrado
}


    public Cliente excluirDoFim()throws ListaVaziaException{
        if(isEmpty()){
            throw new ListaVaziaException();
        }
        Cliente clienteExcluido = primeiro.getCliente();
        if(primeiro == ultimo){
            primeiro = null;
            ultimo = null;
        }else{
            ultimo = ultimo.getAnterior();
        }    
                    
        return clienteExcluido;
    }
    public String exibirTodosClientes(){
          Nodo<Cliente> noAtual = primeiro;//vai comecar percorrer pelo primeiro dado da lista
            String mensagem = null;
            mensagem =  "Dados de todos clientes:\n ";
            String dadosCliente = null;
            boolean encontrado = false;
            
            while( noAtual != null){
                
                dadosCliente = noAtual.getCliente().toString();
                mensagem += dadosCliente + "\n";
                
                noAtual = noAtual.getProximo();
                encontrado = true;
            }
            
            if(!encontrado){
                mensagem = "Erro nenhum cliente cadastrado!";
            }
            
            return mensagem;
    }
    public String buscarCliente(int codigo){
            Nodo<Cliente> noAtual = primeiro;//vai comecar percorrer pelo primeiro dado da lista
            
            while( noAtual != null){
            if(noAtual.getCliente().getCodigo() == codigo){
            
                return noAtual.getCliente().toString();
                }
            noAtual = noAtual.getProximo();
            }
            
        
        return "Erro não tem nenhum cliente cadastrado com este codigo!";
    }
    public void alterarCadastro(int codigo) {
        boolean seguirOperacao = true;
        boolean clienteEncontrado = false;
        
        while(seguirOperacao){
            Nodo<Cliente> noAtual = primeiro;//vai comecar percorrer pelo primeiro dado da lista
            
            while( noAtual != null){
                    if(noAtual.getCliente().getCodigo() == codigo){
                         clienteEncontrado = true;
                String inputOpcao = JOptionPane.showInputDialog(
                "Qual dado do cliente deseja alterar: \n"
                        + "1 - Nome\n"
                        + "2 - Data de nascimento\n"
                        + "3 - Telefone");
                
                int opcao = Integer.parseInt(inputOpcao);
                switch(opcao){
                    case 1:
                        String nome;
                        nome = JOptionPane.showInputDialog(
                                "Informe o nome:");
                        noAtual.getCliente().setNome(nome);
                          JOptionPane.showMessageDialog(null, 
                                "Nome atualizado! " +
                                        noAtual.getCliente().getNome() 
                          + noAtual.getCliente());
                          
                      
                        break;
                    case 2:
                        String dtNascimento = JOptionPane.showInputDialog(
                        "Informe a data de nascimento: Neste formato "
                                + "dd/MM/yyyy");
                        noAtual.getCliente().setDtNasimento(dtNascimento);
                         JOptionPane.showMessageDialog(null, 
                                 "Data de nascimento atualizado! "  +
                                 noAtual.getCliente().getDtNasimento() );
                          break;
                    case 3:
                        String telefone = JOptionPane.showInputDialog(
                        "Informe o numero de telefone: ");
                        noAtual.getCliente().setTelefone(telefone);
                         JOptionPane.showMessageDialog(null, 
                                "Telefone atualizado! " +
                                        noAtual.getCliente().getTelefone());
                          break;
                    default: 
                        JOptionPane.showMessageDialog(null, 
                            "Opção invalida!");       
                }
                break; 
            }
                noAtual = noAtual.getProximo();
            
            }
            
                if(!clienteEncontrado){
                    JOptionPane.showMessageDialog(null, 
                            "Erro não tem nenhum cliente cadastrado "
                                    + "com este codigo!");
                    seguirOperacao = false;
                }else{
                    seguirOperacao = false;
                }
        }
           
    }
    
    
    public boolean isEmpty(){
        return primeiro == null ;
    }
    
    
    
    
}


        

        
