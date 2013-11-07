<?php
    $elementos = array();
     
    for ($i = 0; $i < 1000000; $i++) $elementos[$i] = rand();    
    
    $inicio = microtime();
    
    for ($i = 0; $i < count($elementos); $i++) {
        $elementos[$i];
    }    

    $fim = microtime();
    
    echo ($fim - $inicio);




