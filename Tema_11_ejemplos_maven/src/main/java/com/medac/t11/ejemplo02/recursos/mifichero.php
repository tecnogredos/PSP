<?php
if($_GET){
        if(isset($_GET['usuario'])){
            echo "Hi!!!!, un enorme placer saludarle señor/señora ".$_GET['usuario']."!\n";
        }else{
            echo "Hola, mister Anónimo!\n";
        }
}
?>
