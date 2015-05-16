MAXIMIZE
netprofit1 + netprofit2 + netprofit3 + netprofit4
SUBJECT TO
builders1 + teachers1 + sleepers1 = 40
netprofit1 - 750 builders1 + 200 builders1 + 200 teachers1 + 200 sleepers1 + 300 teachers1 = 0

builders2 + teachers2 + sleepers2 - 3 teachers1 = 40
netprofit2 - 650 builders2 + 200 builders2 + 200 teachers2 + 200 sleepers2 + 300 teachers2 = 0


builders3 + teachers3 + sleepers3  - 3 teachers1 - 3 teachers2 = 40
netprofit3 - 550 builders3 + 200 builders3 + 200 teachers3 + 200 sleepers3 + 300 teachers3 = 0

builders4 + teachers4 + sleepers4  - 3 teachers1 - 3 teachers2 - 3 teachers3 = 40
netprofit4 - 450 builders4 + 200 builders4 + 200 teachers4 + 200 sleepers4 + 300 teachers4 = 0

50 builders1 + 50 builders2 + 50 builders3 + 50builders4 = 20000



BOUNDS
builders1 >= 0
builders2 >= 0
builders3 >= 0
builders4 >= 0
teachers1 >= 0
teachers2 >= 0
teachers3 >= 0
teachers4 >= 0
sleepers1 >= 0
sleepers2 >= 0
sleepers3 >= 0
sleepers4 >= 0


VARIABLES
netprofit1
netprofit2
netprofit3
netprofit4
builders1
builders2
builders3
builders4
teachers1
teachers2
teachers3
teachers4
sleepers1
sleepers2
sleepers3
sleepers4


END