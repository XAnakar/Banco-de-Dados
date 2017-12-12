
package trabalho.pooii.Interfces;

 public  class Variaveis{
        private String Id;
        private String Nome;
        private String cpf;
        private String telefone;
        private String nascimento;

    public Variaveis() {
    }
    
    public Variaveis(String Nome, String cpf, String telefone, String nascimento) {
        this.Nome = Nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.nascimento = nascimento;
    }
        
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
        
}