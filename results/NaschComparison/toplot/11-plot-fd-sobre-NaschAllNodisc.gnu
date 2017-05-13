reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:2500]
set xrange[0:100]
set xlabel "Density"
set ylabel "Flow"
 
#plot filename.txt using ($2):($1) w p t "Fluxo Densidade"
plot "naschp1nd.txt" using 2:1 title "naschp1nd" with points pointtype 7 pointsize 0.1 , \
     "naschp10nd.txt" using 2:1 title "naschp10nd" with points pointtype 7 pointsize 0.1 , \
     "naschp30nd.txt" using 2:1 title "naschp30nd" with points pointtype 7 pointsize 0.1, \
     "naschp70nd.txt" using 2:1 title "naschp70nd" with points pointtype 7 pointsize 0.1


set terminal pdf color 

set out "sobrepostoNaschAllNodisc-fd.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "sobrepostoNaschAllNodisc-fd.eps"
replot



