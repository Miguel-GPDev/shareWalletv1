package com.buybyme.sharewallet.wallet.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.buybyme.sharewallet.R;
import com.buybyme.sharewallet.wallet.model.Wallet;

import java.util.List;


public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.WalletListAdapter> {
    private List<Wallet> walletList;

    public WalletAdapter(List<Wallet> walletList) {
        this.walletList = walletList;
    }

    @NonNull
    @Override
    public WalletAdapter.WalletListAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_wallet,parent,false);
        WalletListAdapter holder = new WalletListAdapter(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WalletAdapter.WalletListAdapter holder, int position) {
        Wallet wallet = walletList.get(position);

        holder.tvDescription.setText(wallet.getDescription());
        holder.tvMessage.setText(String.valueOf(wallet.getMessages()));
        holder.tvMoney.setText(String.valueOf(wallet.getMoney()));
        holder.tvWalletName.setText(wallet.getName());
        holder.tvPeople.setText(String.valueOf(wallet.getPeople()));

    }

    @Override
    public int getItemCount() {
        return walletList.size();
    }

    public class WalletListAdapter extends RecyclerView.ViewHolder {
        TextView tvWalletName, tvMoney, tvPeople, tvDescription, tvMessage;
        CardView cvWallet;

        public WalletListAdapter(@NonNull View itemView) {
            super(itemView);
            tvWalletName = itemView.findViewById(R.id.TV_WALLET_NAME);
            tvMoney = itemView.findViewById(R.id.TV_MONEY);
            tvPeople = itemView.findViewById(R.id.TV_PEOPLE);
            tvDescription = itemView.findViewById(R.id.TV_DESCRIPTION);
            tvMessage = itemView.findViewById(R.id.TV_MESSAGE);

            cvWallet = itemView.findViewById(R.id.CV_WALLET);
        }
    }
}
