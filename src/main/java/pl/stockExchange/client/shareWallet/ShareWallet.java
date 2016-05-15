package pl.stockExchange.client.shareWallet;

import java.util.List;

import pl.stockExchange.bank.helper.SavedShare;

public class ShareWallet {

	String clientSerialId;
	List<SavedShare> savedShare;

	public ShareWallet(String clientSerialId, List<SavedShare> savedShare) {
		super();
		this.clientSerialId = clientSerialId;
		this.savedShare = savedShare;
	}

	public String getClientSerialId() {
		return clientSerialId;
	}

	public void setClientSerialId(String clientSerialId) {
		this.clientSerialId = clientSerialId;
	}

	public List<SavedShare> getSavedShare() {
		return savedShare;
	}

	public void setSavedShare(List<SavedShare> savedShare) {
		this.savedShare = savedShare;
	}

}
