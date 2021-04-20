package com.example.fidelyss;

import java.util.Date;
import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ApiHandler {

    @FormUrlEncoded
    @POST("fidelysapi/inscription.php")
    Call<user> insertUser(
            @Field("id") String var1,
            @Field("sexe") String var2,
            @Field("nom") String var3,
            @Field("prenom") String var4,
            @Field("datenaiss") Date var5,
            @Field("email") String var6,
            @Field("nationalite") String var7,
            @Field("adressedomicile") String var8,
            @Field("ville") String var9,
            @Field("codepostal") String var10,
            @Field("pays") String var11,
            @Field("teldomicile") String var12,
            @Field("telmobile") String var13,
            @Field("societe") String var14,
            @Field("fonction") String var15,
            @Field("telprofessionnel") String var16,
            @Field("fax") String var17,
            @Field("langue") String var18,
            @Field("preference") String var19,
            @Field("paiement") String var20,
            @Field("habitude") String var21,
            @Field("classeh") String var22,
            @Field("assistance") String var23,
            @Field("type") String var24
    );

        @FormUrlEncoded
        @POST("fidelysapi/login.php")
        Call<client> selectUser(
            @Field("id") String var1,
            @Field("pin") String var2
        );

    @FormUrlEncoded
    @POST("fidelysapi/mouvements.php")
    Call<mouvement> getMvt(
            @Field("client") String var1
    );

    @FormUrlEncoded
    @POST("fidelysapi/transactions.php")
    Call<List<transaction>> getTransaction(
            @Field("client") String var1
    );

    @FormUrlEncoded
    @POST("fidelysapi/miles.php")
    Call<String> buyMiles(
            @Field("client") String var1,
            @Field("quantite") String var2,
            @Field("type") String var3
    );

}
