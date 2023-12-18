package desktopApp.core.entity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EstadiaEntity {
	
	// responsavel, nome, idade, sexo
	private ResponsavelEntity responsavel;
	private CriancaEntity crianca;
	private LocalDate data = LocalDate.now();
	private int tempo;
	private double taxa = 1.5;
	private double valor;
	
	public ResponsavelEntity getResponsavel() {
		return this.responsavel;
	}
	public void setResponsavel(ResponsavelEntity responsavel) {
		this.responsavel = responsavel;
	}
	public CriancaEntity getCrianca() {
		return this.crianca;
	}
	public void setCrianca(CriancaEntity crianca) {
		this.crianca = crianca;
	}
	public LocalDate getData() {
		return this.data;
	}
	public String getDataString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.data.format(formatter);
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public double getTaxa() {
		return this.taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	public double getValor() {
		this.valor = tempo * taxa;
		if (tempo > 20) {
			this.valor = this.valor - (this.valor * 0.05);
		}
		else if (tempo > 40) {
			this.valor = this.valor - (this.valor * 0.1);
		}
		else if (tempo > 60) {
			this.valor = this.valor - (this.valor * 0.15);
		}
		
		return valor;
	}
	
	
}