reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:0.04]
set xrange[0:100]
set xlabel "Density"
set ylabel "Probability of Dangerous Situation (Pds)"
 

plot "naschp30-acid.txt" using 1:12 title "NaSch" with lines linecolor rgb "red", \
     "a10b30p30-acid.txt" using 1:12 title "B(10;30)v0" with lines linecolor rgb "8E8424", \
     "a10b30p30-acid.txt" using 1:15 title "B(10;30)v2" with lines linecolor rgb "blue" , \
     "a10b30p30-acid.txt" using 1:16 title "B(10;30)v3" with lines linecolor rgb "black" , \
     "a10b30p30-acid.txt" using 1:17 title "B(10;30)v4" with lines linecolor rgb "#696969" , \
     "a10b30p30-acid.txt" using 1:18 title "B(10;30)v5" with lines linecolor rgb "#8E8424" , \
     "a10b30p30-acid.txt" using 1:19 title "B(10;30)v6" with lines linecolor rgb "#006400" 



set terminal pdf color 

set out "Acid1AllV-a10b30p30.pdf"
replot

set terminal postscript eps color solid lw 2 "Helvetica" 20



set out "Acid1AllV-a10b30p30.eps"
replot



