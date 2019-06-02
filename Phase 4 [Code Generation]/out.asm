.data
Excep1:       .asciiz " arr index out of range !"
Excep2:       .asciiz " Actor Buffer overflow !"
.text
main:
move $fp, $sp
move $t9, $sp
li $t8, 0
li $t7, 0
# adding a CharType global variable
li $a0, 0
sw $a0, 0($gp)
# end of adding a CharType global variable
# start of initializing queues
li $a0, 1
sw $a0, 8($gp)
li $a0, 0
sw $a0, 12($gp)
li $a0, 0
sw $a0, 16($gp)
li $a0, 0
sw $a0, 20($gp)
li $a0, 1
sw $a0, 24($gp)
li $a0, 0
sw $a0, 180($gp)
# end of initializing queues
SCHEDULER:
move $sp, $fp
move $t9, $sp
li $a0, 0
beq $t8, $a0, ACTOR_0
li $a0, 1
beq $t8, $a0, ACTOR_1
ACTOR_0:
lw $a0, 8($gp)
li $t0,2
sltu $t7 , $zero, $a0
addiu $t8, $t8, 1
rem $t8, $t8, $t0
or $t2, $t7, $t8
beqz $t2 END_PROG
bgtz $t8,CONTINUE_0
li $t7, 0
CONTINUE_0:
beqz $a0 SCHEDULER
li $t1, 24
add $t1, $t1, $gp
lw $t2, 12($gp)
li $t3, 52
mul $t2, $t3, $t2
add $t1, $t1, $t2
lw $t1, 0($t1)
j BRANCHES
ACTOR_1:
lw $a0, 16($gp)
li $t0,2
sltu $t7 , $zero, $a0
addiu $t8, $t8, 1
rem $t8, $t8, $t0
or $t2, $t7, $t8
beqz $t2 END_PROG
bgtz $t8,CONTINUE_1
li $t7, 0
CONTINUE_1:
beqz $a0 SCHEDULER
li $t1, 180
add $t1, $t1, $gp
lw $t2, 20($gp)
li $t3, 52
mul $t2, $t3, $t2
add $t1, $t1, $t2
lw $t1, 0($t1)
j BRANCHES
BRANCHES:
li $a0, 1
beq $t1, $a0, RECV_1
li $a0, 2
beq $t1, $a0, RECV_2
li $a0, 3
beq $t1, $a0, RECV_3
# start of adding Label for start of Recv
RECV_1:
# end of adding Label for start of Recv
# start of loading mesg from Q
lw $a0, 8($gp)
addiu $a0, $a0, -1
sw $a0, 8($gp)
lw $t2, 12($gp)
addiu $t2,$t2 , 1
li $t0,2
rem $t2,$t2,$t0
sw $t2, 12($gp)
# end of loading mesg from Q
# adding a IntType variable
li $a0, -1
sw $a0, 0($fp)
# end of adding a IntType variable
# start of adding local var address to stack
addiu $a0, $fp, 0
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# adding a number to stack
li $a0, 10
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
#start of assigning
lw $a0, 8($sp)
lw $t0, 4($sp)
sw $t0,0($a0)
addiu $sp, $sp, 4
#end of assigning
# start of adding local var address to stack
addiu $a0, $fp, 0
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of adding Int variable to stack
lw $a0, 4($sp)
lw $a0, 0($a0)
sw $a0, 4($sp)
# end of adding Int variable to stack
# adding a number to stack
li $a0, 11
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
# adding a number to stack
li $a0, 12
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
# adding a number to stack
li $a0, 13
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
#start of arranging const arr
lw $a0,4($sp)
lw $t0,8($sp)
sw $a0,8($sp)
sw $t0,4($sp)
#end of arranging const arr
# adding a number to stack
li $a0, 14
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
# adding a number to stack
li $a0, 15
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
#start of arranging const arr
lw $a0,4($sp)
lw $t0,8($sp)
sw $a0,8($sp)
sw $t0,4($sp)
#end of arranging const arr
#start of arranging const arr
lw $a0,4($sp)
lw $t0,12($sp)
sw $a0,12($sp)
sw $t0,4($sp)
lw $a0,8($sp)
lw $t0,16($sp)
sw $a0,16($sp)
sw $t0,8($sp)
#end of arranging const arr
# adding a char to stack
li $a0, 99
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a char to stack
# start of adding mesg to Q
lw $a0, 16($gp)
li $t0, 2
beq $a0, $t0, ActorBufferOverFlow
li $t1, 180
lw $t2, 20($gp)
add $t2, $t2, $a0
rem $t0, $t2, $t0
li $t3, 52
mul $t0, $t0, $t3
add $t1, $t1, $t0
addiu $a0, $a0, 1
sw $a0, 16($gp)
li $a0, 3
addu $t1, $t1, $gp
sw $a0, 0($t1)
lw $a0, 4($sp)
sw $a0, 28($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 12($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 16($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 20($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 24($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 8($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 4($t1)
addiu $sp, $sp, 4
# end of adding mesg to Q
# start of adding Label for end of Recv
END_RECV_1:
j SCHEDULER
# end of adding Label for end of Recv
# start of adding Label for start of Recv
RECV_2:
# end of adding Label for start of Recv
# adding a Char ArrType variable
li $a0, 0
sw $a0, 0($fp)
li $a0, 0
sw $a0, 4($fp)
li $a0, 0
sw $a0, 8($fp)
li $a0, 0
sw $a0, 12($fp)
li $a0, 0
sw $a0, 16($fp)
li $a0, 0
sw $a0, 20($fp)
li $a0, 0
sw $a0, 24($fp)
li $a0, 0
sw $a0, 28($fp)
li $a0, 0
sw $a0, 32($fp)
li $a0, 0
sw $a0, 36($fp)
li $a0, 0
sw $a0, 40($fp)
li $a0, 0
sw $a0, 44($fp)
# end of adding a Char ArrType variable
# start of adding local var address to stack
addiu $a0, $fp, 0
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of loading mesg from Q
lw $a0, 8($gp)
li $t1, 24
add $t1, $t1, $gp
lw $t2, 12($gp)
li $t3, 52
mul $t2, $t3, $t2
add $t1, $t1, $t2
lw $t0, 48($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 44($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 40($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 36($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 32($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 28($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 24($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 20($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 16($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 12($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 8($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 4($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
# end of loading mesg from Q
#start of assigning
lw $a0, 52($sp)
lw $t0, 4($sp)
sw $t0,0($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,4($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,8($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,12($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,16($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,20($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,24($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,28($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,32($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,36($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,40($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,44($a0)
addiu $sp, $sp, 4
#end of assigning
# start of loading mesg from Q
lw $a0, 8($gp)
addiu $a0, $a0, -1
sw $a0, 8($gp)
lw $t2, 12($gp)
addiu $t2,$t2 , 1
li $t0,2
rem $t2,$t2,$t0
sw $t2, 12($gp)
# end of loading mesg from Q
# start of adding local var address to stack
addiu $a0, $fp, 0
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of adding ArrType variable to stack
lw $t0, 4($sp)
lw $a0, 44($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 40($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 36($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 32($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 28($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 24($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 20($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 16($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 12($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 8($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 4($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 0($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
addiu $sp, $sp, 4
# end of adding ArrType variable to stack
#start of writing
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
addi $a0, $zero, 10
# start syscall 11
li $v0, 11
syscall
# end syscall
#end of writing
# start of adding Label for end of Recv
END_RECV_2:
j SCHEDULER
# end of adding Label for end of Recv
# start of adding Label for start of Recv
RECV_3:
# end of adding Label for start of Recv
# adding a IntType variable
li $a0, -1
sw $a0, 0($fp)
# end of adding a IntType variable
# start of adding local var address to stack
addiu $a0, $fp, 0
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of loading mesg from Q
lw $a0, 16($gp)
li $t1, 180
add $t1, $t1, $gp
lw $t2, 20($gp)
li $t3, 52
mul $t2, $t3, $t2
add $t1, $t1, $t2
lw $t0, 4($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
# end of loading mesg from Q
#start of assigning
lw $a0, 8($sp)
lw $t0, 4($sp)
sw $t0,0($a0)
addiu $sp, $sp, 4
#end of assigning
# adding a IntType variable
li $a0, -1
sw $a0, 4($fp)
# end of adding a IntType variable
# start of adding local var address to stack
addiu $a0, $fp, 4
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of loading mesg from Q
lw $a0, 16($gp)
li $t1, 180
add $t1, $t1, $gp
lw $t2, 20($gp)
li $t3, 52
mul $t2, $t3, $t2
add $t1, $t1, $t2
lw $t0, 8($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
# end of loading mesg from Q
#start of assigning
lw $a0, 8($sp)
lw $t0, 4($sp)
sw $t0,0($a0)
addiu $sp, $sp, 4
#end of assigning
# adding a Int ArrType variable
li $a0, -1
sw $a0, 8($fp)
li $a0, -1
sw $a0, 12($fp)
li $a0, -1
sw $a0, 16($fp)
li $a0, -1
sw $a0, 20($fp)
# end of adding a Int ArrType variable
# start of adding local var address to stack
addiu $a0, $fp, 8
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of loading mesg from Q
lw $a0, 16($gp)
li $t1, 180
add $t1, $t1, $gp
lw $t2, 20($gp)
li $t3, 52
mul $t2, $t3, $t2
add $t1, $t1, $t2
lw $t0, 24($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 20($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 16($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
lw $t0, 12($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
# end of loading mesg from Q
#start of assigning
lw $a0, 20($sp)
lw $t0, 4($sp)
sw $t0,0($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,4($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,8($a0)
addiu $sp, $sp, 4
lw $t0, 4($sp)
sw $t0,12($a0)
addiu $sp, $sp, 4
#end of assigning
# adding a CharType variable
li $a0, 0
sw $a0, 24($fp)
# end of adding a CharType variable
# start of adding local var address to stack
addiu $a0, $fp, 24
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of loading mesg from Q
lw $a0, 16($gp)
li $t1, 180
add $t1, $t1, $gp
lw $t2, 20($gp)
li $t3, 52
mul $t2, $t3, $t2
add $t1, $t1, $t2
lw $t0, 28($t1)
sw $t0, 0($sp)
addiu $sp, $sp, -4
# end of loading mesg from Q
#start of assigning
lw $a0, 8($sp)
lw $t0, 4($sp)
sw $t0,0($a0)
addiu $sp, $sp, 4
#end of assigning
# start of loading mesg from Q
lw $a0, 16($gp)
addiu $a0, $a0, -1
sw $a0, 16($gp)
lw $t2, 20($gp)
addiu $t2,$t2 , 1
li $t0,2
rem $t2,$t2,$t0
sw $t2, 20($gp)
# end of loading mesg from Q
# start of adding local var address to stack
addiu $a0, $fp, 0
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of adding Int variable to stack
lw $a0, 4($sp)
lw $a0, 0($a0)
sw $a0, 4($sp)
# end of adding Int variable to stack
#start of writing
lw $a0, 4($sp)
# start syscall 1
li $v0, 1
syscall
# end syscall
addiu $sp, $sp, 4
addi $a0, $zero, 10
# start syscall 11
li $v0, 11
syscall
# end syscall
#end of writing
# start of adding local var address to stack
addiu $a0, $fp, 4
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of adding Int variable to stack
lw $a0, 4($sp)
lw $a0, 0($a0)
sw $a0, 4($sp)
# end of adding Int variable to stack
#start of writing
lw $a0, 4($sp)
# start syscall 1
li $v0, 1
syscall
# end syscall
addiu $sp, $sp, 4
addi $a0, $zero, 10
# start syscall 11
li $v0, 11
syscall
# end syscall
#end of writing
# start of adding local var address to stack
addiu $a0, $fp, 24
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of adding char variable to stack
lw $a0, 4($sp)
lw $a0, 0($a0)
sw $a0, 4($sp)
# end of adding char variable to stack
#start of writing
lw $a0, 4($sp)
# start syscall 11
li $v0, 11
syscall
# end syscall
addiu $sp, $sp, 4
addi $a0, $zero, 10
# start syscall 11
li $v0, 11
syscall
# end syscall
#end of writing
# start of adding local var address to stack
addiu $a0, $fp, 8
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of adding ArrType variable to stack
lw $t0, 4($sp)
lw $a0, 12($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 8($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 4($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 0($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
addiu $sp, $sp, 4
# end of adding ArrType variable to stack
# adding a number to stack
li $a0, 2
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
# adding a number to stack
li $a0, 0
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
# start of begin block
sw $t9, 0($sp)
move $t9, $sp
addiu $sp, $sp, -4
# end of begin block
# start of putting for Label
LOOP_0:
# end of putting for Label
# adding a Int ArrType variable
li $a0, -1
sw $a0, 40($fp)
li $a0, -1
sw $a0, 44($fp)
# end of adding a Int ArrType variable
# start of adding local var address to stack
addiu $a0, $fp, 40
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of assigning ID
li $a0, 8
lw $t2, 12($sp)
mul $t0 , $t2, $a0
addiu $t0 , $t0, 20
add $t0, $t0, $sp
lw $a0,4($sp)
lw $t1,0($t0)
sw $t1,0($a0)
lw $t1,4($t0)
sw $t1,4($a0)
lw $t3, 16($sp)
beq $t3, $t2, END_LOOP_0
addiu $t2, $t2, 1
sw $t2, 12($sp)
# end of assigning ID
# start of adding local var address to stack
addiu $a0, $fp, 40
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of adding ArrType variable to stack
lw $t0, 4($sp)
lw $a0, 4($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
lw $a0, 0($t0)
sw $a0, 4($sp)
addiu $sp, $sp, -4
addiu $sp, $sp, 4
# end of adding ArrType variable to stack
# adding a number to stack
li $a0, 2
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
# adding a number to stack
li $a0, 0
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a number to stack
# start of begin block
sw $t9, 0($sp)
move $t9, $sp
addiu $sp, $sp, -4
# end of begin block
# start of putting for Label
LOOP_1:
# end of putting for Label
# adding a IntType variable
li $a0, -1
sw $a0, 44($fp)
# end of adding a IntType variable
# start of adding local var address to stack
addiu $a0, $fp, 44
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of assigning ID
li $a0, 4
lw $t2, 12($sp)
mul $t0 , $t2, $a0
addiu $t0 , $t0, 20
add $t0, $t0, $sp
lw $a0,4($sp)
lw $t1,0($t0)
sw $t1,0($a0)
lw $t3, 16($sp)
beq $t3, $t2, END_LOOP_1
addiu $t2, $t2, 1
sw $t2, 12($sp)
# end of assigning ID
# start of adding local var address to stack
addiu $a0, $fp, 44
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding local var address to stack
# start of adding Int variable to stack
lw $a0, 4($sp)
lw $a0, 0($a0)
sw $a0, 4($sp)
# end of adding Int variable to stack
#start of writing
lw $a0, 4($sp)
# start syscall 1
li $v0, 1
syscall
# end syscall
addiu $sp, $sp, 4
addi $a0, $zero, 10
# start syscall 11
li $v0, 11
syscall
# end syscall
#end of writing
# start of putting Label for END LOOP 
move $sp, $t9
addiu $sp,$sp ,-4
j LOOP_1
END_LOOP_1:
# end of putting Label for END LOOP 
# start of end block
move $sp, $t9
lw $t9, 0($sp)
# end of end block
# start of putting Label for END LOOP 
move $sp, $t9
addiu $sp,$sp ,-4
j LOOP_0
END_LOOP_0:
# end of putting Label for END LOOP 
# start of end block
move $sp, $t9
lw $t9, 0($sp)
# end of end block
# adding a string to stack
li $a0, 63
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 105
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 98
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 117
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 104
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 107
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 32
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 109
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 97
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 108
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 97
sw $a0, 0($sp)
addiu $sp, $sp, -4
li $a0, 115
sw $a0, 0($sp)
addiu $sp, $sp, -4
# end of adding a string to stack
# start of adding mesg to Q
lw $a0, 8($gp)
li $t0, 3
beq $a0, $t0, ActorBufferOverFlow
li $t1, 24
lw $t2, 12($gp)
add $t2, $t2, $a0
rem $t0, $t2, $t0
li $t3, 52
mul $t0, $t0, $t3
add $t1, $t1, $t0
addiu $a0, $a0, 1
sw $a0, 8($gp)
li $a0, 2
addu $t1, $t1, $gp
sw $a0, 0($t1)
lw $a0, 4($sp)
sw $a0, 4($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 8($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 12($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 16($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 20($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 24($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 28($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 32($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 36($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 40($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 44($t1)
addiu $sp, $sp, 4
lw $a0, 4($sp)
sw $a0, 48($t1)
addiu $sp, $sp, 4
# end of adding mesg to Q
# start of adding Label for end of Recv
END_RECV_3:
j SCHEDULER
# end of adding Label for end of Recv
# start syscall 10
li $v0, 10
syscall
# end syscall
IndexOutOfRange:
li $v0, 4
la $a0, Excep1
syscall
j END_PROG
ActorBufferOverFlow:
li $v0, 4
la $a0, Excep2
syscall
j END_PROG
END_PROG:
li $v0, 10
syscall
