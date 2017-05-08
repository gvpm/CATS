reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:2500]
set xrange[0:100]
set xlabel "Density"
set ylabel "Flow"
 
#plot filename.txt using ($2):($1) w p t "Fluxo Densidade"
plot "naschp10.txt" using 2:1 title "naschp10" with points pointtype 1 , \
     "-a1b6p10.txt" using 2:3 title "a1b6p10" with points pointtype 1 , \
     "-a4b8p10.txt" using 2:3 title "a4b8p10" with points pointtype 1 , \
     "-a8b4p10.txt" using 2:3 title "a8b4p10" with points pointtype 1 


set terminal pdf color 

set out "sobreposto10ivan-fd.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "sobreposto10ivan-fd.eps"
replot



