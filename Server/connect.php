<?php
    $hostname="localhost";
    $username="id16927496_tinmp3";
    $password="12345";
    $databasename="id16927496_androidmp3";

    $con=mysqli_connect($hostname,$username,$password,$databasename);
    mysqli_query($con,"SET NAMES 'utf8'");
    if($con){
        echo"Kết nối thành công";
    }
    else{
        echo"Kết nối thất bại!";
    }
?>