package model.single;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConfigPc {
	
	@Column(name="ram")
	private int RAM;
	
	@Column(name="SE")
	private String OS;
	
	
	public ConfigPc() {
	}

	

	public ConfigPc(int RAM, String oS) {
		RAM = RAM;
		OS = oS;
	}



	public int getRAM() {
		return RAM;
	}


	public void setRAM(int rAM) {
		RAM = rAM;
	}


	public String getOS() {
		return OS;
	}


	public void setOS(String oS) {
		OS = oS;
	}
	
	

}
