package com.eventersapp.marketplace.ui.rekeyaccount;

import android.util.Log;

import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.algod.client.AlgodClient;
import com.algorand.algosdk.algod.client.ApiException;
import com.algorand.algosdk.algod.client.api.AlgodApi;
import com.algorand.algosdk.algod.client.auth.ApiKeyAuth;
import com.algorand.algosdk.algod.client.model.NodeStatus;
import com.algorand.algosdk.algod.client.model.TransactionID;
import com.algorand.algosdk.algod.client.model.TransactionParams;
import com.algorand.algosdk.crypto.Address;
import com.algorand.algosdk.crypto.Digest;
import com.algorand.algosdk.transaction.SignedTransaction;
import com.algorand.algosdk.transaction.Transaction;
import com.algorand.algosdk.util.Encoder;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.Security;

public class SubmitTx {

    public static TransactionID rekeyAccount(String mnemonics, String rekeyToAddress) throws GeneralSecurityException {
        final String ALGOD_API_ADDR = "<ALGO_API-ADDR>"; //Replace with your algo api address
        final String ALGOD_API_TOKEN = "<ALGO_API-TOKEN>"; //Replace with your algo api token

        final String SRC_ACCOUNT = mnemonics;

        //Setup HTTP client w/guest key provided by PureStake
        AlgodClient client = new AlgodClient();

        client.addDefaultHeader("X-API-Key", ALGOD_API_TOKEN);

        client.setBasePath(ALGOD_API_ADDR);
        // Configure API key authorization: api_key
        ApiKeyAuth api_key = (ApiKeyAuth) client.getAuthentication("api_key");
        api_key.setApiKey(ALGOD_API_TOKEN);

        AlgodApi algodApiInstance = new AlgodApi(client);
        Security.removeProvider("BC");
        Security.insertProviderAt(new BouncyCastleProvider(), 0);
        Account src = new Account(SRC_ACCOUNT);
        Log.i("Info", "My Address: " + src.getAddress());
        Log.i("Info", "RekeyTo Address: " + rekeyToAddress);

        BigInteger feePerByte;
        String genesisID;
        Digest genesisHash;
        long firstRound = 0L;
        try {
            TransactionParams params = algodApiInstance.transactionParams();
            feePerByte = params.getFee();
            genesisHash = new Digest(params.getGenesishashb64());
            genesisID = params.getGenesisID();
            Log.i("Info", "Suggested Fee: " + feePerByte);
   