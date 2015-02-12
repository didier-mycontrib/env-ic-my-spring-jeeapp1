package tp.app.zz.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import tp.app.zz.itf.domain.service.GestionDevises;

@ManagedBean
@RequestScoped
public class Conversion {
	
	private String monnaie1,monnaie2;
	private Double montant;
	private Double sommeConvertie;
	
	@ManagedProperty(value="#{gestionDevisesImpl}") //ici  #{idSrping}
	private GestionDevises serviceDevises;
	
	public String convertir(){
		sommeConvertie=serviceDevises.convertir(montant, monnaie1, monnaie2);
		return null;//rester sur meme page
	}
	
	public String getMonnaie1() {
		return monnaie1;
	}
	public void setMonnaie1(String monnaie1) {
		this.monnaie1 = monnaie1;
	}
	public String getMonnaie2() {
		return monnaie2;
	}
	public void setMonnaie2(String monnaie2) {
		this.monnaie2 = monnaie2;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Double getSommeConvertie() {
		return sommeConvertie;
	}
	public void setSommeConvertie(Double sommeConvertie) {
		this.sommeConvertie = sommeConvertie;
	}

	public GestionDevises getServiceDevises() {
		return serviceDevises;
	}

	public void setServiceDevises(GestionDevises serviceDevises) {
		this.serviceDevises = serviceDevises;
	}
	
	

}
