<?php
    if ($_SERVER['REQUEST_METHOD']=='POST')
    {  
        include "bd.php";
        $id=$_POST['id']; 
        $pin=$_POST['pin'];
        $email=$_POST['email'];
        $hash=password_hash($pin, PASSWORD_BCRYPT);
        $update1= "UPDATE client set pin='$hash' where id='$id' "; 
        $res1=$bd->exec($update1); 
            if ($res1){
                $to= $email;
                $subject = "PIN Modifié";
                $message="Votre PIN a été modifier avec succés";
                $headers= "From: noreply@fidelys.tn";
                $headers .="MIME-Version:1.0"."\r\n";
                $headers .="Content-type:text/html;charset=UTF-8"."\r\n";
                mail($to,$subject,$message,$headers);
                $result='sent';
            }
            else{
                $result='erreur';
            }
        echo $result;
    }
?>