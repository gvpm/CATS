reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:25000]
set xrange[0:100]
set xlabel "Density"
set ylabel "Flow"
 
#plot filename.txt using ($2):($1) w p t "Fluxo Densidade"
plot "naschp30.txt" using 2:1 title "naschp30" with lines, \
     "a10b30p30-1p.txt" using 2:1 title "a10b30p30" with lines , \
     "a30b10p30-1p.txt" using 2:1 title "a30b10p30" with lines



set terminal pdf color 

set out "sobreposto30-fd.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "sobreposto30-fd.eps"
replot



