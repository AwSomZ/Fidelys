<?php
    if($_SERVER['REQUEST_METHOD']=='POST') 
        {
                include "bd.php";
                $user=$_POST['user'];
                $token=$_POST['token'];
                $expire = date('Y-m-d',strtotime(date("Y-m-d", mktime()) . " + 3 year"));
                $today=date("Y-m-d");
                $userv=$bd->prepare("select * from user_verification where user='$user';");
                $userv->execute();
                if ($userv->rowCount()>0)
                    {
                        $d=$userv->fetchAll(PDO::FETCH_ASSOC);
                        $t=$d[0]['token'];
                        if($token==$t)
                        {
                            $query=$bd->prepare("select * from user where id='$user';");
                            $query->execute();

                            if($query->rowCount()>0)
                                {
                                    $data=$query->fetchAll(PDO::FETCH_ASSOC);
                                    $cin=$data[0]['id'];
                                    $sexe=$data[0]['sexe'];
                                    $nom=$data[0]['nom'];
                                    $prenom=$data[0]['prenom'];
                                    $date=$data[0]['datenaiss'];
                                    $email=$data[0]['email'];
                                    $nationalite=$data[0]['nationalite'];
                                    $adr=$data[0]['adressedomicile'];
                                    $ville=$data[0]['ville'];
                                    $cp=$data[0]['codepostal'];
                                    $pays=$data[0]['pays'];
                                    $teld=$data[0]['teldomicile'];
                                    $telm=$data[0]['telmobile'];
                                    //creation de l id 
                                    $nbr=$bd->prepare("select * from client;");
                                    $nbr->execute();
                                    $c = $nbr->rowCount();
                                    do 
                                        {
                                            $c=$c+1;
                                            $count= (string) $c;
                                            $nb = strlen($count);
                                            $err =9- $nb ; 
                                            $code="";
                                            for ($x = 0; $x < $err; $x++)
                                                {   
                                                    $code="0".$code;
                                                }
                                            $code=$code.$count;
                                            $pin = (string) rand(100000000,999999999);
                                            $ok=$bd->prepare("select * from client where id='$code' ;");
                                            $ok->execute();
                                        }
                                    while($ok->rowCount()>0);
                                    //fin id
                                    $hash=password_hash($pin, PASSWORD_BCRYPT);
                                    $sq="insert into client (`id`, `pin`, `cin`, `sexe`, `nom`, `prenom`, `datenaiss`, `email`, `nationalite`, `adressedomicile`, `ville`, `codepostal`, `pays`, `teldomicile`, `telmobile`) VALUES 
                                    ('$code','$hash','$cin','$sexe','$nom','$prenom','$date','$email','$nationalite','$adr','$ville','$cp','$pays','$teld','$telm');";
                                    $re=$bd->exec($sq);
                                    if ($re) 
                                        {
                                            $to= $email;
                                            $subject = "Vos Information De Connexion";
                                            $message="Votre Identifiant : $code <br> Votre Pin : $pin  ";
                                            $headers= "From: noreply@fidelys.tn";
                                            $headers .="MIME-Version:1.0"."\r\n";
                                            $headers .="Content-type:text/html;charset=UTF-8"."\r\n";
                                            mail($to,$subject,$message,$headers);
                                            $age= date_diff(date_create('today'),date_create($date))->y;
                                            if ($age<=24)
                                                {
                                                    $plafond=15000;
                                                }
                                            else
                                                {
                                                    $plafond=13000;
                                                }
                                            $mvt= "insert into mouvement (`milesprime`,`client`,`plafond`,`date_niveau`,`date_expiration`,`statut`) values ('3000','$code','$plafond','$today','$expire','classic');";
                                            $re=$bd->exec($mvt);
                                            $delete = "DELETE from user where id='$user' ";
                                            $deletev = "DELETE from user_verification where user='$user' ";    
                                            
                                            $rev=$bd->exec($deletev);
                                            $res=$bd->exec($delete);
                                            $result='verifie';
                                        }
                               
                                }
                        }
                        else
                            {
                                $result='incorrect';
                            }   
                    }  
                    else
                    {
                        $result='error';
                    }      
                    echo $result;
        }
?>