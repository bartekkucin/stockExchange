package pl.stockExchange.client.shareWallet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pl.stockExchange.bank.helper.SavedShare;

public class ShareWalletManager {

	public ShareWallet createShareWallet(String clientSerialId) {
		return new ShareWallet(clientSerialId, null);
	}

	ShareWallet updateShareWallet(int clientSerialId) {
		return null;
	}

	public List<SavedShare> findSharesByCompanyName(List<String> companies, ShareWallet shareWallet) {
		List<SavedShare> resultShares = new ArrayList<>();
		for (Iterator<SavedShare> iter = shareWallet.getSavedShare().listIterator(); iter.hasNext();) {
			SavedShare share = iter.next();
			for (String company : companies) {
				if (share.getCompanyName().equals(company)) {
					resultShares.add(share);
				}
			}

		}
		return resultShares;

	}

	public ShareWallet deleteShareFromShareWallet(SavedShare savedShare2Delete, ShareWallet shareWallet) {
		for (Iterator<SavedShare> iter = shareWallet.getSavedShare().listIterator(); iter.hasNext();) {
			SavedShare share = iter.next();
			if (share.getCompanyName().equals(savedShare2Delete.getCompanyName())) {
				if (savedShare2Delete.getAmount() - share.getAmount() == 0) {
					iter.remove();
				} else {
					share.setAmount(savedShare2Delete.getAmount() - share.getAmount());

				}

			}
		}
		return shareWallet;

	}

	public ShareWallet addShare2ShareWallet(SavedShare share2Save, ShareWallet shareWallet) {
		List<SavedShare> shares = new ArrayList<>();
		if (shareWallet.getSavedShare() != null) {
			for(SavedShare savShare : shareWallet.getSavedShare())
			{

				if (share2Save.getCompanyName().equals((savShare.getCompanyName()))) {
					savShare.setAmount(share2Save.getAmount() + savShare.getAmount());
				}
				else {
					SavedShare shh = new SavedShare(share2Save.getAmount(), share2Save.getCostSum(),
							share2Save.getCompanyName());
					shares.add(shh);
				}



			}
				shareWallet.getSavedShare().addAll(shares);


		} else {
			List<SavedShare> sShares = new ArrayList<>();
			sShares.add(share2Save);
			shareWallet.setSavedShare(sShares);
		}
		return shareWallet;
	}

}
