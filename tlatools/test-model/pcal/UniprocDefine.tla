----------------------------- MODULE UniprocDefine -------------------------- 
EXTENDS Naturals, Sequences, TLC

(*   
--algorithm UniprocDefine
  variables n = 0 ;
  define nplus1 == n + 1
         nplus2 == nplus1 + 1
  end define ;
  procedure Foo(a)
    variable b = 2 ;
    begin foo : n := nplus2 + a + b ;
                return ;
    end procedure ; 
  begin  main : call Foo(2) ;
         minor: assert n = 6 ;
  end algorithm
*)
					
(***** BEGIN TRANSLATION ***)
CONSTANT defaultInitValue
VARIABLES n, pc, stack

(* define statement *)
nplus1 == n + 1
nplus2 == nplus1 + 1

VARIABLES a, b

vars == << n, pc, stack, a, b >>

Init == (* Global variables *)
        /\ n = 0
        (* Procedure Foo *)
        /\ a = defaultInitValue
        /\ b = 2
        /\ stack = << >>
        /\ pc = "main"

foo == /\ pc = "foo"
       /\ n' = nplus2 + a + b
       /\ pc' = Head(stack).pc
       /\ b' = Head(stack).b
       /\ a' = Head(stack).a
       /\ stack' = Tail(stack)

Foo == foo

main == /\ pc = "main"
        /\ /\ a' = 2
           /\ stack' = << [ procedure |->  "Foo",
                            pc        |->  "minor",
                            b         |->  b,
                            a         |->  a ] >>
                        \o stack
        /\ b' = 2
        /\ pc' = "foo"
        /\ n' = n

minor == /\ pc = "minor"
         /\ Assert(n = 6, "Failure of assertion at line 16, column 17.")
         /\ pc' = "Done"
         /\ UNCHANGED << n, stack, a, b >>

Next == Foo \/ main \/ minor
           \/ (* Disjunct to prevent deadlock on termination *)
              (pc = "Done" /\ UNCHANGED vars)

Spec == Init /\ [][Next]_vars

Termination == <>(pc = "Done")

(***** END TRANSLATION ***)
=============================================================================
