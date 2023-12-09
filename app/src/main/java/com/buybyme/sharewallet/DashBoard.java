package com.buybyme.sharewallet;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.buybyme.sharewallet.commons.WalletCommons;
import com.buybyme.sharewallet.wallet.model.Wallet;
import com.buybyme.sharewallet.wallet.adapters.WalletAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DashBoard extends AppCompatActivity {

    private RecyclerView rvWallets;
    private WalletAdapter walletAdapter;
    private List<Wallet> walletList = new ArrayList<>();
    private ImageView ivAddWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        ivAddWallet = findViewById(R.id.IV_ADD_WALLET);

        rvWallets = findViewById(R.id.RV_WALLETS);
        String apiKey = "sk_test_51O1OzXJWEMiOmKII13VPzxFBgb0vAFhVM5AkbC4zbSUJ1NFIMhywCkkKwfHzDO2nrYHkhI5m9yxBc0kwvgz72O2y00CcJJK3bO";
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        currentUser.getIdToken(true)
                .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
            @Override
            public void onComplete(@NonNull Task<GetTokenResult> task) {
                String token = task.getResult().getToken();
                Log.i("token", token);
            }
        });

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String url = "/".concat(WalletCommons.USERS)
                .concat("/")
                .concat(currentUser.getUid())
                .concat("/")
                .concat(WalletCommons.WALLETS);

        db.collection(url)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Wallet wallet = document.toObject(Wallet.class);
                                walletList.add(wallet);
                                Log.d(TAG, wallet.getId() + " => " + wallet.getName());
                            }
                            addToRecycler(walletList);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

        ivAddWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void addToRecycler(List<Wallet> list){
        rvWallets.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.VERTICAL ,false));
        walletAdapter = new WalletAdapter(list);
        rvWallets.setAdapter(walletAdapter);
    }
}