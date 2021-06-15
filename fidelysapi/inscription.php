<?php
    if ($_SERVER['REQUEST_METHOD']=='POST')
        {
            include "bd.php";
            $id=$_POST['id'];
            $nom=$_POST['nom'];
            $prenom=$_POST['prenom'];
            $sexe=$_POST['sexe'];
            $datenaiss=$_POST['datenaiss'];
            $email=$_POST['email'];
            $nationalite=$_POST['nationalite'];
            $adr=$_POST['adressedomicile'];
            $cp=$_POST['codepostal'];
            $pays=$_POST['pays'];
            $ville=$_POST['ville'];
            $teld=$_POST['teldomicile'];
            $telm=$_POST['telmobile'];
            $datecreation = date("Y-m-d");
            $sql="insert into  user (id, sexe, nom, prenom, datenaiss, email, nationalite, adressedomicile, ville, codepostal, pays, teldomicile, telmobile) VALUES
            ('$id','$sexe','$nom','$prenom','$datenaiss','$email','$nationalite','$adr','$ville','$cp','$pays','$teld','$telm');";
            $res=$bd->exec($sql);
            $token=substr(md5(uniqid($id ,true)), 0, 5);
            $verif="insert into  user_verification (token, datecreation, user) VALUES
            ('$token','$datecreation','$id');";
            $verification=$bd->exec($verif);
            $to= $email;
            $subject = "Email Verification";
            $message="Le Code Pour Activer Votre Compte Est : $token";
            $headers= "From: noreply@fidelys.tn";
            $headers .="MIME-Version:1.0"."\r\n";
            $headers .="Content-type:text/html;charset=UTF-8"."\r\n";
            mail($to,$subject,$message,$headers);
        }
?>