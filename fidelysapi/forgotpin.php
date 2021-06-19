<?php
    if ($_SERVER['REQUEST_METHOD']=='POST')
    {   
        include "bd.php";
        $id=$_POST['id'];
        $query=$bd->prepare("select * from client where id='$id' ");
        $query->execute();
        if($query->rowCount()>0)
        {
            $data=$query->fetchAll(PDO::FETCH_ASSOC);
            $email=$data[0]['email'];
            $oldpin=$data[0]['pin'];
            if (strlen($oldpin)<=60){
                $pin = (string) rand(100000000,999999999);
                $hash=password_hash($pin, PASSWORD_BCRYPT);
                $newhash=$oldpin.$hash;
                $update1= "UPDATE client set pin='$newhash' where id='$id' "; 
                $res1=$bd->exec($update1); 
                if ($res1){
                    $to= $email;
                    $subject = "Pin Oublie";
                    $message="Pin à usage unique: $pin vous devez changer votre mot de passe des que vous connectez à votre compte";
                    $headers= "From: noreply@fidelys.tn";
                    $headers .="MIME-Version:1.0"."\r\n";
                    $headers .="Content-type:text/html;charset=UTF-8"."\r\n";
                    mail($to,$subject,$message,$headers);
                    $result='sent';
                }
                else{
                    $result='errorr';
                }
            }  
            else {
                $result="non";
            } 
            
        }
        else 
        {
            $result='invalid';
        }
	    echo $result;
    }
?>