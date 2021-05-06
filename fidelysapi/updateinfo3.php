<?php
	if ($_SERVER['REQUEST_METHOD']=='POST')
		{
			include "bd.php";
			$id=$_POST['id'];
			$classh=$_POST['classeh'];
			$type=$_POST['type'];
			$assistance=$_POST['assistance'];
			$paiement=$_POST['paiement'];
			$pref=$_POST['pref'];
			$habitude=$_POST['habitude'];
			$sql="UPDATE client SET classeh='$classh', assistance='$assistance', type='$type', habitude='$habitude',paiement='$paiement',preference='$pref' where id='$id';";
			$res=$bd->exec($sql);
		}
?>