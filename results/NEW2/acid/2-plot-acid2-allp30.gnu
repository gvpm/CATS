reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:0.05]
set xrange[0:100]
set xlabel "Density"
set ylabel "Accident Probability"
 

plot "naschp30-acid.txt" using 1:13 title "Nasch p=0.30" with lines, \
     "a10b30p30-acid.txt" using 1:13 title "a10b30 p=0.30" with lines, \
     "a30b10p30-acid.txt" using 1:13 title "a30b10 p=0.30" with lines



set terminal pdf color 

set out "Acid2-allp30.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "Acid2-allp30.eps"
replot



