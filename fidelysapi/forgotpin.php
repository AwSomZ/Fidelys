<?php
	include'bd.php';
	$id=$_POST['id'];
	$query=$bd->prepare("select * from client where id='$id' ");
	$query->execute();
	if($query->rowCount()>0)
		{
	
			
            $data=$query->fetchAll(PDO::FETCH_ASSOC);
            $pin=$data[0]['pin'];
            $email=$data[0]['email'];
            $to= $email;
			$subject = "Email Verification";
            $message="Votre Code Pin Est : $pin";
            $headers= "From: noreply@fidelys.tn";
            $headers .="MIME-Version:1.0"."\r\n";
            $headers .="Content-type:text/html;charset=UTF-8"."\r\n";
            mail($to,$subject,$message,$headers);
            echo 'sent';
		}
    else {
        echo 'not found';
    }
?>