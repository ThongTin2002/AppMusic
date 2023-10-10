<?php
    require 'connect.php';
    $query="SELECT DISTINCT * FROM playlist ORDER BY rand(" .date("Ymd"). ") LIMIT 3";
    class PlaylistToday{
        public function PlaylistToday($idplaylist,$ten,$hinh,$icon)
        {
            $this ->IdPlaylist=$idplaylist;
            $this ->Ten=$ten;
            $this ->HinhPlaylist=$hinh;
            $this ->Icon=$icon;
        }
    }
    $arrayplaylistfortoday=array();
    $data=mysqli_query($con,$query);
    while($row=mysqli_fetch_assoc($data)){
        array_push($arrayplaylistfortoday,new PlaylistToday($row['idPlayList'],
        $row['Ten'],$row['HinhNen'],$row['HinhIcon']));
    }
    echo json_encode($arrayplaylistfortoday);
?>