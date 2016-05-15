package pl.stockExchange.client;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import pl.stockExchange.bank.bankAccount.service.IBankService;
import pl.stockExchange.bank.enums.BankAccountCurrencyTypeEnum;
import pl.stockExchange.bank.helper.SavedShare;
import pl.stockExchange.bank.model.entity.to.BankAccountTo;
import pl.stockExchange.broker.IBrokerOffice;
import pl.stockExchange.client.shareWallet.ShareWallet;
import pl.stockExchange.client.shareWallet.ShareWalletManager;

@Component
public class Client {

	@Autowired
	private IBankService bankService;

	@Autowired
	private IBrokerOffice broker;

	ShareWalletManager shareWalletManager = new ShareWalletManager();

	private String clientSerialNumber;
	// private List<BankAccountTo> bankAccountsList;
	private ShareWallet shareWallet;

	public Client() {
		super();
	}


	public void dosth() {
		System.out.println(this.getClientSerialNumber());
	}

	public void sellShares(List<String> shares) {
		BigDecimal actualCash = bankService.getMoneyFromBankAccountByClientIdAndCurrency(this.getClientSerialNumber(),
				BankAccountCurrencyTypeEnum.PLN);

		List<SavedShare> avalibleShares = shareWalletManager.findSharesByCompanyName(shares, this.shareWallet);

		for (Iterator<SavedShare> iter = avalibleShares.listIterator(); iter.hasNext();) {
			SavedShare share = iter.next();
			int amountGenerator = share.getAmount();
			BigDecimal earnedValue = broker.buy(share.getCompanyName(), amountGenerator);
			this.setShareWallet(shareWalletManager.deleteShareFromShareWallet(share, this.shareWallet));
			actualCash=actualCash.add(earnedValue);
			

		}
		BankAccountTo bankAccount = bankService.findBankAccountBySerialidAndCurrencyType(this.clientSerialNumber,
				BankAccountCurrencyTypeEnum.PLN);
		bankAccount.setAmount(actualCash);
		bankService.update(bankAccount);
		
		System.out.println(bankService.getMoneyFromBankAccountByClientIdAndCurrency(this.getClientSerialNumber(),
				BankAccountCurrencyTypeEnum.PLN));

	}

	public void buyShares(List<String> shares) {
		BigDecimal avalibleCash = bankService.getMoneyFromBankAccountByClientIdAndCurrency(this.getClientSerialNumber(),
				BankAccountCurrencyTypeEnum.PLN);
		for (Iterator<String> iter = shares.listIterator(); iter.hasNext();) {
			String share = iter.next();
			int amountGenerator = (int) (Math.random() * 10);
			SavedShare share2Save = broker.sell(share, amountGenerator);
			int compareResult = share2Save.getCostSum().compareTo(avalibleCash);
			// 1 - first higher
			// 0 - equal
			if (compareResult <= 0) {
				this.setShareWallet(shareWalletManager.addShare2ShareWallet(share2Save, this.shareWallet));

			}
			BankAccountTo bankAccount = bankService.findBankAccountBySerialidAndCurrencyType(
					this.clientSerialNumber, BankAccountCurrencyTypeEnum.PLN);
			bankAccount.setAmount(avalibleCash.subtract(share2Save.getCostSum()));
			bankService.update(bankAccount);

		}
		System.out.println(bankService.getMoneyFromBankAccountByClientIdAndCurrency(this.getClientSerialNumber(),
				BankAccountCurrencyTypeEnum.PLN));
	}

	public String getClientSerialNumber() {
		return clientSerialNumber;
	}

	public void setClientSerialNumber(String clientSerialNumber) {
		this.clientSerialNumber = clientSerialNumber;
	}

	public ShareWallet getShareWallet() {
		return shareWallet;
	}

	public void setShareWallet(ShareWallet shareWallet) {
		this.shareWallet = shareWallet;
	}

}
