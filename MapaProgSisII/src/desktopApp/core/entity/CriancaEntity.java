package desktopApp.core.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CriancaEntity {
	
	// responsavel, nome, idade, sexo
	private ResponsavelEntity responsavel;
	private String nome;
	private LocalDate dataNascimento;
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String sexo;
	
	public ResponsavelEntity getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(ResponsavelEntity responsavel) {
		this.responsavel = responsavel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public String getDataNascimentoString() {
		return this.dataNascimento.format(this.dataFormatter);
	}
	public void setDataNascimento(String dataNascimento, String formatter) {
		this.dataNascimento = LocalDate.parse(dataNascimento,  DateTimeFormatter.ofPattern(formatter));
	}
	public int getIdade() {
		LocalDate dataAtual = LocalDate.now();
		int idade = Period.between(this.dataNascimento, dataAtual).getYears();
		return idade;
		
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}