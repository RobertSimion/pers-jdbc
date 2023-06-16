import matplotlib.pyplot as plt

x = [500, 1000, 2000, 5000, 10000, 20000, 50000, 100000, 200000, 500000]
y_mysql_insert = [334, 533, 794, 1638, 3501, 5988, 16645, 31591, 60259, 237409]
y_mssql_insert = [200, 282, 628, 1500, 3078, 9055, 14806, 30123, 57431, 131802]
y_oracle_insert = [181, 233, 355, 895, 1748, 4352, 10165, 28387, 52239, 101308]
y_postgres_insert = [199, 253, 425, 1499, 1694, 4135, 9504, 21085, 40139, 121073]


y_insert_link_mysql = [246, 333, 659, 1620, 3361, 8474, 22979, 48337, 94767, 314320]
y_insert_link_mssql = [43, 49, 104, 204, 365, 658, 2251, 4219, 10129, 27192]
y_insert_link_oracle = [14, 20, 43, 82, 187, 383, 953, 1834, 2737, 7484]
y_insert_link_postgres = [43, 68, 151, 498, 676, 1159, 2691, 8023, 22301, 59801]


y_insert_batch_mysql = [188, 376, 626, 1359, 2717, 5700, 20988, 30809, 81883, 201637]
y_insert_batch_mssql = [188, 376, 626, 1359, 2717, 5700, 20988, 30809, 81883, 201637]
y_insert_batch_oracle = [39, 47, 78, 175, 352, 596, 1962, 3910, 10439, 23331]
y_insert_batch_postgres = [34, 74, 132, 422, 573, 1191, 2203, 4981, 9578, 17980]

y_select_mysql = [8, 54, 84, 293, 1243, 3858, 12923, 18543, 28954, 49325]
y_select_mssql = [8, 43, 48, 193, 432, 1954, 7834, 18435, 24884, 39832]
y_select_oracle = [8, 32, 83, 546,3854, 12584, 21853, 32945, 58954, 96439]
y_select_postgres = [8, 32, 129, 291, 349, 883, 2949, 12994, 23943, 41835]


y_select_joined_mysql = [8, 43, 89, 399, 885, 2148, 9358, 14958, 24584, 48321]
y_select_joined_mssql = [8, 64,59, 125,1285, 2941, 8493, 13049, 19995, 39210]
y_select_joined_oracle = [8, 49,234,834, 4239, 9432,19584, 24854,59954, 96439]
y_select_joined_postgres = [8, 43,49, 129, 230, 894, 2394, 7843, 18754, 40128]


y_update_mysql = [233,439, 1293, 2399, 4994, 6934, 27695, 49235, 87795, 179342]
y_update_mssql = [391,499, 857,1385, 4388, 23095, 82342, 188543, 238854, 499128]
y_update_oracle = [381,438, 695,1348, 4325, 12309, 24943, 84323, 134854,385894]
y_update_postgres = [289,439, 954, 3495, 5488, 18834, 43885, 132438, 392924, 583124]


y_delete_mysql = [15,44,144, 895, 3834, 21394,65489, 94388,219234,483925]
y_delete_mssql = [15,654,2102, 3999, 6943, 31209,95832, 183940, 337821, 674832]
y_delete_oracle = [15, 54, 854, 3954, 8439, 53943,103464,194532,283821, 598652]
y_delete_postgres = [15,329, 949, 1543, 3843, 9210, 38489, 99193, 399439, 783402]

y_delete_joined_mysql = [15,44,163,493,4399,16943,54339, 83432, 189854,487213]
y_delete_joined_mssql = [15,482,1029,2394, 4934,29393,98231, 183942, 385432, 776854]
y_delete_joined_oracle = [15,59, 349, 1294, 4593, 43825, 98342, 198438, 290034, 578434]
y_delete_joined_postgres = [15,234,893, 1300,2399, 12092, 29349, 102332,399312, 785491]

y_delete_batch_mysql = [15, 15,125,980,4898,29399,49953, 75834, 129938, 417203]
y_delete_batch_mssql = [15,389,943, 2914, 4834, 29889,83432, 164392, 321985, 589321]
y_delete_batch_oracle = [15,49,233,843,2984, 34954, 74382,149231,274389,489233]
y_delete_batch_postgres = [15,45,193,421,983,8312,18241,89993,293223,632023]


y_mongo_insert_values = [512, 838, 1255, 2395, 3593, 4626, 12510, 27016, 42837, 123461]
y_mongo_select_values = [53, 72, 86, 132, 210, 351, 684, 1308, 2184, 5181]
y_mongo_update_values = [340, 521, 806, 1820, 2673, 8583, 47050, 188629, 235491, 481277]
y_mongo_delete_values = [9, 13, 24, 58, 84, 164, 430, 802, 2210, 10249]

#
y_spring_insert_mysql_values = [1656,2727,4077,6975,19638,30888,96714,158439,436677,860769]
y_spring_insert_mssql_values = [1470,2730,3936,6957, 20487,35952,105636, 164763, 437997, 879609]
y_spring_insert_oracle_values = [1887, 2346, 4455, 10293,21105,51168,146778, 234099, 402060, 834458]
y_spring_insert_postgres_values = [1257, 1770, 3870, 6558, 19503,34770,89550,155592,388626,809196]

y_spring_update_mysql_values = [735, 834, 1389,3273,5409,11652, 40065,68805,119136,276642]
y_spring_update_mssql_values = [1698,2913,5187,11478,22503,44850,107034,241518, 511866,936282]
y_spring_update_oracle_values = [1002,1257,2295,7644,10773,14754,44559,105369,176802,403629]
y_spring_update_postgres_values = [2298,3003,5493, 10857,20829, 46020,109626,268292,631626,933523]

y_spring_select_mysql_values = [2046, 2370, 3840, 5394,10470,17409, 55317,90387,234936,359199]
y_spring_select_mssql_values = [1698,2913,5187,11478,22503,44850,107034,241518, 511866,936282]
y_spring_select_oracle_values = [1002,1257,2295,7644,10773,14754,44559,105369,176802,403629]
y_spring_select_postgres_values = [2196,1851,3591,5385,10974,20100,53052,94620,212052,371835]

y_spring_delete_mysql_values = [87,132,210,603,1821,4770,25044,99384,461703,1004392]
y_spring_delete_mssql_values = [153,207,300,870,1293,4647,20796,105036,552912,1642393]
y_spring_delete_oracle_values = [99,177,246,702,1824,5157,29964, 116646,498195,1438323]
y_spring_delete_postgres_values = [300,585,1062,1629,2529,6309, 30987,117381,644012,1698430]


#
y_spring_insert_mysql_values_warmup = [1744,807,1186,2759,5409,17879,43988,94906,193879,478170]
y_spring_insert_mssql_values_warmup = [1054,1075,1203,2981,5943,29394,49993,120234,198543,389435]
y_spring_insert_oracle_values_warmup = [973,1059,1634,4864,13045,25948,45546,103143,241483,533255]
y_spring_insert_postgres_values_warmup = [583,555,747,3118,5755,12993,27222,43925,127592,2963963]

y_spring_update_mysql_values_warmup = [990,827,1536,3910,8780,16953,42912,49323,98230,312049]
y_spring_update_mssql_values_warmup = [542,1023,1501,2832,7432,12594,43813,74329,187843,389423]
y_spring_update_oracle_values_warmup = [322,391,533,1664,2652,5437,14939,26307,59577,152435]
y_spring_update_postgres_values_warmup = [246,265,457,1127,2175,3828,8022,19674,31541,77691]

y_spring_select_mysql_values_warmup = [651,581,916,2691,4833,9899,22838,49188,104493,244003]
y_spring_select_mssql_values_warmup = [301,501,604,1902,2319,4901,15931,31945,59231,98563]
y_spring_select_oracle_values_warmup = [612,614,901,2288,2996,8250,20440,35484,82881,217115]
y_spring_select_postgres_values_warmup = [445,450,834,1831,3384,5771,14850,29790,62929,153932]

y_spring_delete_mysql_values_warmup = [43,53,44,185,893,4393,16543,32032,89865,163968]
y_spring_delete_mssql_values_warmup = [40,60,130,201,491,6934,12933,34209,78334,298954]
y_spring_delete_oracle_values_warmup = [40,47,81,228,623,1980,12685,38054,128342,359332]
y_spring_delete_postgres_values_warmup = [19,63,117,559,1753,7405,21984,49832,112934,483921]


fig, ax = plt.subplots()


ax.plot(x, y_mysql_insert, color='blue', label='MYSQL')
ax.plot(x, y_mssql_insert, color='red', label='MSSQL')
ax.plot(x, y_oracle_insert, color='green', label='ORACLE')
ax.plot(x, y_postgres_insert, color='purple', label='POSTGRES')


ax.set_title('Insert Ops Jdbc')
ax.set_xlabel('No. Ops')
ax.set_ylabel('Execution time [ms]')

ax.legend()


fig2, ax2 = plt.subplots()

ax2.plot(x, y_insert_link_mysql, color='blue', label='MYSQL')
ax2.plot(x, y_insert_link_mssql, color='red', label='MSSQL')
ax2.plot(x, y_insert_link_oracle, color='green', label='ORACLE')
ax2.plot(x, y_insert_link_postgres, color='purple', label='POSTGRES')

ax2.set_title('Insert Link Ops Jdbc')
ax2.set_xlabel('No. Ops')
ax2.set_ylabel('Execution time [ms]')


ax2.legend()



fig3, ax3 = plt.subplots()

ax3.plot(x, y_insert_batch_mysql, color='blue', label='MYSQL')
ax3.plot(x, y_insert_batch_mssql, color='red', label='MSSQL')
ax3.plot(x, y_insert_batch_oracle, color='green', label='ORACLE')
ax3.plot(x, y_insert_batch_postgres, color='purple', label='POSTGRES')

ax3.set_title('Insert Batch Ops Jdbc')
ax3.set_xlabel('No. Ops')
ax3.set_ylabel('Execution time [ms]')


ax3.legend()


fig4, ax4 = plt.subplots()

ax4.plot(x, y_select_mysql, color='blue', label='MYSQL')
ax4.plot(x, y_select_mssql, color='red', label='MSSQL')
ax4.plot(x, y_select_oracle, color='green', label='ORACLE')
ax4.plot(x, y_select_postgres, color='purple', label='POSTGRES')

ax4.set_title('Select Ops Jdbc')
ax4.set_xlabel('No. Ops')
ax4.set_ylabel('Execution time [ms]')


ax4.legend()

fig5, ax5 = plt.subplots()

ax5.plot(x, y_select_joined_mysql, color='blue', label='MYSQL')
ax5.plot(x, y_select_joined_mssql, color='red', label='MSSQL')
ax5.plot(x, y_select_joined_oracle, color='green', label='ORACLE')
ax5.plot(x, y_select_joined_postgres, color='purple', label='POSTGRES')

ax5.set_title('Select Join Ops. Jdbc')
ax5.set_xlabel('No. Ops')
ax5.set_ylabel('Execution time [ms]')


ax5.legend()

fig6, ax6 = plt.subplots()

ax6.plot(x, y_update_mysql, color='blue', label='MYSQL')
ax6.plot(x, y_update_mssql, color='red', label='MSSQL')
ax6.plot(x, y_update_oracle, color='green', label='ORACLE')
ax6.plot(x, y_update_postgres, color='purple', label='POSTGRES')

ax6.set_title('Update Ops. Jdbc')
ax6.set_xlabel('No. Ops')
ax6.set_ylabel('Execution time [ms]')


ax6.legend()


fig7, ax7 = plt.subplots()

ax7.plot(x, y_delete_mysql, color='blue', label='MYSQL')
ax7.plot(x, y_delete_mssql, color='red', label='MSSQL')
ax7.plot(x, y_delete_oracle, color='green', label='ORACLE')
ax7.plot(x, y_delete_postgres, color='purple', label='POSTGRES')

ax7.set_title('Delete Ops. Jdbc')
ax7.set_xlabel('No. Ops')
ax7.set_ylabel('Execution time [ms]')


ax7.legend()



fig8, ax8 = plt.subplots()

ax8.plot(x, y_delete_joined_mysql, color='blue', label='MYSQL')
ax8.plot(x, y_delete_joined_mssql, color='red', label='MSSQL')
ax8.plot(x, y_delete_joined_oracle, color='green', label='ORACLE')
ax8.plot(x, y_delete_joined_postgres, color='purple', label='POSTGRES')

ax8.set_title('Delete Joined Ops. Jdbc')
ax8.set_xlabel('No. Ops')
ax8.set_ylabel('Execution time [ms]')


ax8.legend()


fig9, ax9 = plt.subplots()

ax9.plot(x, y_delete_batch_mysql, color='blue', label='MYSQL')
ax9.plot(x, y_delete_batch_mssql, color='red', label='MSSQL')
ax9.plot(x, y_delete_batch_oracle, color='green', label='ORACLE')
ax9.plot(x, y_delete_batch_postgres, color='purple', label='POSTGRES')

ax9.set_title('Delete Batch Ops. Jdbc')
ax9.set_xlabel('No. Ops')
ax9.set_ylabel('Execution time [ms]')


ax9.legend()

fig10, ax10 = plt.subplots()

ax10.plot(x, y_mongo_insert_values, color='blue', label='CREATE')
ax10.plot(x, y_mongo_select_values, color='red', label='READ')
ax10.plot(x, y_mongo_update_values, color='green', label='UPDATE')
ax10.plot(x, y_mongo_delete_values, color='purple', label='DELETE')

ax10.set_title('Mongo CRUD')
ax10.set_xlabel('No. Ops')
ax10.set_ylabel('Execution time [ms]')


ax10.legend()

fig11, ax11 = plt.subplots()

ax11.plot(x, y_spring_insert_mysql_values, color='blue', label='MYSQL')
ax11.plot(x, y_spring_insert_mssql_values, color='red', label='MSSQL')
ax11.plot(x, y_spring_insert_oracle_values, color='green', label='ORACLE')
ax11.plot(x, y_spring_insert_postgres_values, color='purple', label='POSTGRES')

ax11.set_title('Spring Data JDBC Insert')
ax11.set_xlabel('No. Ops')
ax11.set_ylabel('Execution time [ms]')


ax11.legend()

fig12, ax12 = plt.subplots()

ax12.plot(x, y_spring_update_mysql_values, color='blue', label='MYSQL')
ax12.plot(x, y_spring_update_mssql_values, color='red', label='MSSQL')
ax12.plot(x, y_spring_update_oracle_values, color='green', label='ORACLE')
ax12.plot(x, y_spring_update_postgres_values, color='purple', label='POSTGRES')

ax12.set_title('Spring Data JDBC Update')
ax12.set_xlabel('No. Ops')
ax12.set_ylabel('Execution time [ms]')


ax12.legend()

fig13, ax13 = plt.subplots()

ax13.plot(x, y_spring_select_mysql_values, color='blue', label='MYSQL')
ax13.plot(x, y_spring_select_mssql_values, color='red', label='MSSQL')
ax13.plot(x, y_spring_select_oracle_values, color='green', label='ORACLE')
ax13.plot(x, y_spring_select_postgres_values, color='purple', label='POSTGRES')

ax13.set_title('Spring Data JDBC Select')
ax13.set_xlabel('No. Ops')
ax13.set_ylabel('Execution time [ms]')


ax13.legend()


fig14, ax14 = plt.subplots()

ax14.plot(x, y_spring_delete_mysql_values, color='blue', label='MYSQL')
ax14.plot(x, y_spring_delete_mssql_values, color='red', label='MSSQL')
ax14.plot(x, y_spring_delete_oracle_values, color='green', label='ORACLE')
ax14.plot(x, y_spring_delete_postgres_values, color='purple', label='POSTGRES')

ax14.set_title('Spring Data JDBC Delete')
ax14.set_xlabel('No. Ops')
ax14.set_ylabel('Execution time [ms]')


ax14.legend()

fig15, ax15 = plt.subplots()

ax15.plot(x, y_spring_insert_mysql_values_warmup, color='blue', label='MYSQL')
ax15.plot(x, y_spring_insert_mssql_values_warmup, color='red', label='MSSQL')
ax15.plot(x, y_spring_insert_oracle_values_warmup, color='green', label='ORACLE')
ax15.plot(x, y_spring_insert_postgres_values_warmup, color='purple', label='POSTGRES')

ax15.set_title('Spring Data JDBC Insert WARM-UP')
ax15.set_xlabel('No. Ops')
ax15.set_ylabel('Execution time [ms]')


ax15.legend()


fig16, ax16 = plt.subplots()

ax16.plot(x, y_spring_update_mysql_values_warmup, color='blue', label='MYSQL')
ax16.plot(x, y_spring_update_mssql_values_warmup, color='red', label='MSSQL')
ax16.plot(x, y_spring_update_oracle_values_warmup, color='green', label='ORACLE')
ax16.plot(x, y_spring_update_postgres_values_warmup, color='purple', label='POSTGRES')

ax16.set_title('Spring Data JDBC Update WARM-UP')
ax16.set_xlabel('No. Ops')
ax16.set_ylabel('Execution time [ms]')


ax16.legend()

fig17, ax17 = plt.subplots()

ax17.plot(x, y_spring_select_mysql_values_warmup, color='blue', label='MYSQL')
ax17.plot(x, y_spring_select_mssql_values_warmup, color='red', label='MSSQL')
ax17.plot(x, y_spring_select_oracle_values_warmup, color='green', label='ORACLE')
ax17.plot(x, y_spring_select_postgres_values_warmup, color='purple', label='POSTGRES')

ax17.set_title('Spring Data JDBC Select WARM-UP')
ax17.set_xlabel('No. Ops')
ax17.set_ylabel('Execution time [ms]')


ax17.legend()


fig18, ax18 = plt.subplots()

ax18.plot(x, y_spring_delete_mysql_values_warmup, color='blue', label='MYSQL')
ax18.plot(x, y_spring_delete_mssql_values_warmup, color='red', label='MSSQL')
ax18.plot(x, y_spring_delete_oracle_values_warmup, color='green', label='ORACLE')
ax18.plot(x, y_spring_delete_postgres_values_warmup, color='purple', label='POSTGRES')

ax18.set_title('Spring Data JDBC Delete WARM-UP')
ax18.set_xlabel('No. Ops')
ax18.set_ylabel('Execution time [ms]')


ax18.legend()


plt.show()
