<?php

$name = 'test_applicationmere.jar';
$file = 'D:\Anne-Camille\Documents\I2\Logiciels Et Donnes';
header('Content-disposition: attachment; filename="'.$name.'"');
header('Content-Type: application/force-download');
header('Content-Transfer-Encoding: fichier');
header('Content-Length: '.filesize($file));
header('Pragma: no-cache');
header('Cache-Control: no-store, no-cache, must-revalidate, post-check=0, pre-check=0');
header('Expires: 0');
readfile($file);
exit();		

?>