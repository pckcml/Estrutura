public class Estrutura {
    
    // Criação da classe Lista
    private static class Lista {
        // Atributos
        private final int[] itensLista;
        private int nextPosicaoLista;
        
        // Construtor
        public Lista(int tamanhoLista) {
            // Declaração de array e inicialização com zero
            itensLista = new int[tamanhoLista];
            for (int i = 0; i < itensLista.length; i++) {
                itensLista[i] = 0x00;
            }
            // Guarda posição do próximo item a ser visitado na chamada
            nextPosicaoLista = 0;
        }
        // Método para inserir item
        public void inserirItemLista(int valorItem) {
            itensLista[nextPosicaoLista] = valorItem;
            nextPosicaoLista++;
        }
        // Método para remover item, a partir do último
        public int removerItemLista() {
            // Adquire valor do último item com base no nextPosicaoLista
            int ultimoItem = itensLista[nextPosicaoLista - 1];
            // Substitui de volta para zero
            itensLista[nextPosicaoLista - 1] = 0x00;
            nextPosicaoLista--;
            // Retorno para que possa ser usado na escrita de outros métodos
            return ultimoItem;
        }
    }
    
    // Criação da classe Fila
    private static class Fila {
        // Atributos
        private final int[] itensFila;
        private int nextPosicaoEntrarFila;
        private int nextPosicaoSairFila;
        
        // Construtor
        public Fila(int tamanhoFila) {
            // Declaração do array e inicialização com zero
            itensFila = new int[tamanhoFila];
            for (int i = 0; i < itensFila.length; i++) {
                itensFila[i] = 0x00;
            }
            // Guardam posição para ordem de inserção e remoção
            nextPosicaoEntrarFila = 0;
            nextPosicaoSairFila = 0;
        }
        // Método para inserir item
        public void inserirItemFila(int valorItem) {
            itensFila[nextPosicaoEntrarFila] = valorItem;
            nextPosicaoEntrarFila++;
        }
        // Método para remover item, a partir do primeiro
        public int removerItemFila() {
            // Adquire valor do primeiro item com base no nextPosicaoSairFila
            int primeiroItem = itensFila[nextPosicaoSairFila];
            // Substitui de volta para zero
            itensFila[nextPosicaoSairFila] = 0x00;
            nextPosicaoSairFila++;
            // Retorno caso fosse usado na escrita de outros métodos
            return primeiroItem;
        }
        // Método para imprimir valores, único solicitado no enunciado de fato
        public void imprimirFila() {
            System.out.println("Listagem de itens da fila: ");
            for (int i = 0; i < itensFila.length; i++) {
                System.out.println("Item " + (i + 1) + ": " + itensFila[i]);
            }
        }
    }
    
    // Criação da classe Pilha
    private static class Pilha {
        // Atributos
        private final int[] itensPilha;
        private int topoPilha;
        
        // Construtor
        public Pilha(int tamanhoPilha) {
            // Declaração de array e inicialização com zero
            itensPilha = new int[tamanhoPilha];
            for (int i = 0; i < itensPilha.length; i++) {
                itensPilha[i] = 0x00;
            }
            // Guarda posição para ordem de inserção e remoção
            topoPilha = 0;
        }
        // Método para inserir item
        public void inserirItemPilha(int valorItem) {
            itensPilha[topoPilha] = valorItem;
            topoPilha++;
        }
        // Método para remover item, a partir do topo da pilha
        public int removerItemPilha() {
            // Referência direta ao item no topo para sua remoção
            int itemTopoPilha = itensPilha[topoPilha - 1];
            itensPilha[topoPilha - 1] = 0x00;
            topoPilha--;
            // Retorno para uso em outras chamadas
            return itemTopoPilha;
        }
    }
    
    public static void main(String[] args) {
        // Variável para iterações nos laços de repetição
        int n;
        
        // Passo 1 - Inserir números 1-5 em lista com 5 posições
        // Chamada de construtor Lista
        Lista objLista = new Lista(5);
        
        // Inserção de valores de 1 a 5
        n = 1;
        while (n < 6) {
            objLista.inserirItemLista(n);
            n++;
        }
        
        // Passo 2 - Remover todos da lista e inserir em pilha com 5 posições
        // Chamada de construtor Pilha
        Pilha objPilha = new Pilha(5);
        
        // Chamada de método removerItemLista encadeada na chamada de inserção
        n = 1;
        while (n < 6) {
            objPilha.inserirItemPilha(objLista.removerItemLista());
            n++;
        }
        
        // Passo 3 - Remover todos da pilha e inserir em fila com 10 posições
        // Chamada de construtor Fila
        Fila objFila = new Fila(10);
        
        // Chamada de método removerItemPilha encadeada na chamada de inserção
        n = 1;
        while (n < 6) {
            objFila.inserirItemFila(objPilha.removerItemPilha());
            n ++;
        }
        
        // Passo 4 - Inserir números 6 a 10 na lista;
        n = 6;
        while (n < 11) {
            objLista.inserirItemLista(n);
            n++;
        }
        
        // Passo 5 - Repetir passos 2 e 3
        // Passo 2.R - Chamada de remoção da Lista encadeada em inserir na Pilha
        n = 1;
        while (n < 6) {
            objPilha.inserirItemPilha(objLista.removerItemLista());
            n++;
        }
        
        // Passo 3.R - Chamada de remoção da Pilha encadeada na inserção da Fila
        n = 1;
        while (n < 6) {
            objFila.inserirItemFila(objPilha.removerItemPilha());
            n ++;
        }
        
        // Passo 6 - Exibir todos os itens da fila - Chamada do método imprimir
        objFila.imprimirFila();
    }
}
