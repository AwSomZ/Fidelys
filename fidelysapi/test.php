<?php
$d=password_hash("985764106", PASSWORD_BCRYPT);
$new=password_hash("102348988", PASSWORD_BCRYPT);
$password=$d.$new;
$s='$2y$10$UkWETGSNWsC02JzkUVnABuZbuRgO8byNvX1TG5ilR7Ruk/Kc00o9K';
echo strlen($s);
echo '</br>';
$rest = substr($password, 60);
echo $d;
echo '</br>';
echo strlen($d);
echo '</br>';
echo $new;
echo '</br>';
echo strlen($password);
echo '</br>';
echo $password;
echo '</br>';
echo $rest;
echo '</br>';
$newpin=str_replace($rest, "",$password);
echo $newpin;
if (strlen($new)==60){
    echo 'good';
}
else {
    echo 'no';
}

if (password_verify("102348988", $rest)){
    echo 'good';
}
else {
    echo 'no';
}

?>