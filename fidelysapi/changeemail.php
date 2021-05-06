<?php
    if ($_SERVER['REQUEST_METHOD']=='POST')
        {   
            $id=$_POST['client'];
            $email=$_POST['email'];
            $newemail=$_POST['newemail'];
            $to=$email;
            $subject =  "Email Verification";
            $message=" <a href='http://localhost/fidelysapi/validateemail.php?client=$id&newemail=$newemail'>Change your email </a> ";
            $headers="From: noreply@fidelys.tn";
            $headers .="MIME-Version:1.0"."\r\n";
            $headers .="Content-type:text/html;charset=UTF-8"."\r\n";
            mail($to,$subject,$message,$headers);
        }
?>