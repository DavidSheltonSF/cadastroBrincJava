package desktopApp.core.entity;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ResponsavelEntity {
	
	// nome, cpf, telefone, email, endereço, idade
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String endereco;
	private LocalDate dataNascimento;
	private DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereço) {
		this.endereco = endereço;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public String getDataNascimentoString() {
		return this.dataNascimento.format(this.dataFormatter);
	}
	public void setDataNascimento(String dataNascimento, String formatter) {
		this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern(formatter));
	}
	public int getIdade() {
		LocalDate dataAtual = LocalDate.now();
		int idade = Period.between(this.dataNascimento, dataAtual).getYears();
		return idade;
	}
}
