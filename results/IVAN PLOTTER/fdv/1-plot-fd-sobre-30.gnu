reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:2000]
set xrange[0:100]
set xlabel "Density"
set ylabel "Flow"


plot "naschp30-1p.txt" using 2:1 title "NaSch" with lines linecolor rgb "red", \
     "a10b30p30-1p.txt" using 2:1 title "B(10;30)" with lines linecolor rgb "blue", \
     "a20b28p30-1p.txt" using 2:1 title "B(20;28)" with lines linecolor rgb "black", \
     "a28b20p30-1p.txt" using 2:1 title "B(28;20)" with lines linecolor rgb "#696969", \
     "a30b10p30-1p.txt" using 2:1 title "B(30;10)" with lines linecolor rgb "#006400"



set terminal pdf color 

set out "sobreposto30-fd.pdf"
replot

set terminal postscript eps color solid lw 2 "Helvetica" 20

set out "sobreposto30-fd.eps"
replot



