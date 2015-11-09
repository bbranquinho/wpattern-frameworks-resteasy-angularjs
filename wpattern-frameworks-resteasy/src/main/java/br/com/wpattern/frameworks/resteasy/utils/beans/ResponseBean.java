package br.com.wpattern.frameworks.resteasy.utils.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseBean extends BaseBean {
	private static final long serialVersionUID = 1L;
	private int result;
	public ResponseBean() {
	}
	public ResponseBean(int result) {
		this.result = result;
	}
	public int getResult() {
		return this.result;
	}
	public void setResult(int result) {
		this.result = result;
	}
}
