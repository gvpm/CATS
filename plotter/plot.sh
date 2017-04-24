#!/bin/bash
gnuplot -e "filename='$1'" plot-fd.gnu
gnuplot -e "filename='$1'" plot-vd.gnu

