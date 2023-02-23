<?php
//    $many = 2.2888800;
//    $many_2 = 2.2111200;
//    $few = $many + $many_2;
   
//    print("$many + $many_2 = $few <br>");

//    if (TRUE)
//    print("This will always print<br>");

// else
//    print("This will never print<br>");

$equipo = array('portero'=>'Cech', 'defensa'=>'Terry', 'medio'=>'Lampard', 'delantero'=>'Torres');
 
foreach($equipo as $posicion=>$jugador)
	{
	echo "El defensa " . $equipo['defensa'] . " y el delantero juegan juntos " . "<br>";
	echo "<br>";
	}
?>