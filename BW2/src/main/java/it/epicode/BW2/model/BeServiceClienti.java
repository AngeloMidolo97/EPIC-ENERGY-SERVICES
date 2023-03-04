package it.epicode.BW2.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the be_service_clienti database table.
 * 
 */
@Entity
@Table(name="be_service_clienti")
//@NamedQuery(name="BeServiceClienti.findAll", query="SELECT b FROM BeServiceClienti b")
public class BeServiceClienti {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="cognome_contatto", length=255)
	private String cognomeContatto;
	
	@Column(name="data_inserimento")
	private Timestamp dataInserimento;

	@Column(name="data_ultimo_contatto")
	private Timestamp dataUltimoContatto;

	@Column(length=255)
	private String email;

	@Column(name="email_contatto", length=255)
	private String emailContatto;

	@Column(name="fatturato_annuale", precision=19, scale=2)
	private BigDecimal fatturatoAnnuale;

	@Column(name="nome_contatto", length=255)
	private String nomeContatto;

	@Column(name="partita_iva", length=255)
	private String partitaIva;

	@Column(length=255)
	private String pec;

	@Column(name="ragione_sociale", length=255)
	private String ragioneSociale;

	@Column(length=255)
	private String telefono;

	@Column(name="telefono_contatto", length=255)
	private String telefonoContatto;

	@Column(name="tipo_cliente", length=255)
	private String tipoCliente;

	//bi-directional many-to-one association to BeServiceIndirizzi
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="indirizzo_sede_legale_id")
	private BeServiceIndirizzi beServiceIndirizzi1;

	//bi-directional many-to-one association to BeServiceIndirizzi
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="indirizzo_sede_operativa_id")
	private BeServiceIndirizzi beServiceIndirizzi2;
	
	
	//bi-directional many-to-one association to BeServiceFatture
	@OneToMany(mappedBy="beServiceClienti")
	@JsonBackReference
	private List<BeServiceFatture> beServiceFattures;

	public BeServiceClienti() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCognomeContatto() {
		return this.cognomeContatto;
	}

	public void setCognomeContatto(String cognomeContatto) {
		this.cognomeContatto = cognomeContatto;
	}

	public Timestamp getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Timestamp dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Timestamp getDataUltimoContatto() {
		return this.dataUltimoContatto;
	}

	public void setDataUltimoContatto(Timestamp dataUltimoContatto) {
		this.dataUltimoContatto = dataUltimoContatto;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailContatto() {
		return this.emailContatto;
	}

	public void setEmailContatto(String emailContatto) {
		this.emailContatto = emailContatto;
	}

	public BigDecimal getFatturatoAnnuale() {
		return this.fatturatoAnnuale;
	}

	public void setFatturatoAnnuale(BigDecimal fatturatoAnnuale) {
		this.fatturatoAnnuale = fatturatoAnnuale;
	}

	public String getNomeContatto() {
		return this.nomeContatto;
	}

	public void setNomeContatto(String nomeContatto) {
		this.nomeContatto = nomeContatto;
	}

	public String getPartitaIva() {
		return this.partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getPec() {
		return this.pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
	}

	public String getRagioneSociale() {
		return this.ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonoContatto() {
		return this.telefonoContatto;
	}

	public void setTelefonoContatto(String telefonoContatto) {
		this.telefonoContatto = telefonoContatto;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public BeServiceIndirizzi getBeServiceIndirizzi1() {
		return this.beServiceIndirizzi1;
	}

	public void setBeServiceIndirizzi1(BeServiceIndirizzi beServiceIndirizzi1) {
		this.beServiceIndirizzi1 = beServiceIndirizzi1;
	}

	public BeServiceIndirizzi getBeServiceIndirizzi2() {
		return this.beServiceIndirizzi2;
	}

	public void setBeServiceIndirizzi2(BeServiceIndirizzi beServiceIndirizzi2) {
		this.beServiceIndirizzi2 = beServiceIndirizzi2;
	}

	public List<BeServiceFatture> getBeServiceFattures() {
		return this.beServiceFattures;
	}

	public void setBeServiceFattures(List<BeServiceFatture> beServiceFattures) {
		this.beServiceFattures = beServiceFattures;
	}

	public BeServiceFatture addBeServiceFatture(BeServiceFatture beServiceFatture) {
		getBeServiceFattures().add(beServiceFatture);
		beServiceFatture.setBeServiceClienti(this);

		return beServiceFatture;
	}

	public BeServiceFatture removeBeServiceFatture(BeServiceFatture beServiceFatture) {
		getBeServiceFattures().remove(beServiceFatture);
		beServiceFatture.setBeServiceClienti(null);

		return beServiceFatture;
	}

}