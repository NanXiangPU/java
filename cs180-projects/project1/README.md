CS180 Project 1 - Repetition
The purpose of this project is to help you become more familiar with scanners, String manipulation, conditionals, and advanced usage of the for loop.

These skills will help you in job interviews and future projects.

Introduction
One of the great unsolved problems of the 20th century was sequencing the entire human genome. Until our genome was sequenced we had an incomplete view of our evolution, diseases, migrations as a species and genetic differences.

One of the most challenging parts of sequencing the genome was putting it all together. This was left to computer scientists. Gene sequencing machines work by splitting DNA down into small fragments, replicating them thousands of times with radioactive nucleotices, and finally reading them back.

The problem is that a human genome has three billion (3,000,000,000) base pairs and the sequencer processes about 500 random pairs at a time. Sequencing software pieces all of these together matching the overlaps to reconstruct the whole thing.

You are going to build sequencing software that:

Reads in and re-constructs overlapping sequences
Checks to make sure the DNA is valid
Looks for genes in the DNA
Prints out an analysis of the gene
Note:

Please do the project chronologically as you cannot test a section without first completely its predecessor.
Part 1 - Reconstruction
Problem

The first part of your DNA analysis program is going to be finding the longest terminating overlap between the DNA you have so far and the new DNA the sequencer gives you. Look at the following example:

We start with no DNA:
Your DNA:      ""
Sequencer DNA: "ATATATATA"
New Sequence:  "ATATATATA"


Your DNA:      "ATATATATA"
Sequencer DNA:       "ATACATGA"
New Sequence:  "ATATATATACATGA"


Your DNA:      "ATATATATA"
Sequencer DNA:       "ATACATGA"
New Sequence:  "ATATATATACATGA"
Preparation

Know how to use the Scanner
Know how to use the substring, startsWith and endsWith methods in String
Get a sheet of paper and write down instructions telling your roommate how to find the longest terminating overlap.
Things To Do

Create a class Sequencer
Create a public static void main(String[] args) method in Sequencer, this is where you will put all your code.
Ask the user for input by printing "Input lowercase DNA fragments one line at a time. End with a blank line."
Read lines of DNA from the input
Convert the line to lower case
Join the line with the current DNA on their longest terminating overlap like the example above.
Stop scanning when the user enters a blank line.
If the input contains any characters that are not a, t, c or g print "DNA is invalid" and return otherwise print "Input DNA: " followed by the joined DNA.
Notes

You may assume the input DNA is lower-case
You may assume that each line of input will have at lease one overlap
Example

Here is an example up to this point with the DNA ccatgctaatttag:

Input lowercase DNA fragments one line at a time. End with a blank line.
ccatgctaa
taatttag

Input DNA: ccatgctaatttag
Part 2 - Finding a Gene
Problem

DNA sequences only get us halfway to finding what we really want. Genes are sequences of DNA that help cells build proteins. Proteins help your body make chemical reactions, color your eyes, fend off disease and more. When we've found a sequence that encodes a protein it means we can learn more about the person whose DNA it is.

Proteins all start with the letters “atg”, stop with “tag”, “taa” or “tga” and have a multiple of three characters between them.

Some examples of valid proteins (here we've added spaces for readability, your DNA will have none):

atg tag         // empty
atg aaa taa     // single codon
atg cgc gtt tga // two codons
atg cta att tag
Preparation

Write down instructions for how you'd find a gene in DNA. Here are some things to include:
How do you find the start codon?
How do you know how far to look ahead?
How do you know when to stop?
Think about each of the three parts of the for loop and how you could use each to solve the algorithm you wrote down.
Things To Do

Find the location of the start codon in the DNA
If there is no start codon print "DNA does not contain a gene start codon" and exit.
Find the location of the end of the gene.
The gene ends when one of the three stop strings is found (“tag”, “taa”, “tga”).
The number of characters between the start codon and the end must be a multiple of 3.
If there is no valid end codon print "DNA does not contain a gene end codon" and exit.
Print this as well if the number of characters between the start codon and the end is not a multiple of 3.
Print "Start codon position: " concatenated with the location of the start codon string
Print "End codon position: " concatenated with the location of the end codon position
Print "Gene: " concatenated with the characters of the DNA between the start codon position and the end position.
Notes

There may be more than one (1) start codon in the DNA. You only need to look at the first one.
The end codon will not be included in the “Gene” printout.
Example

Here is an example up to this point with the DNA ccatgctaatttag:

Input lowercase DNA fragments one line at a time. End with a blank line.
ccatgctaatttag

Input DNA: ccatgctaatttag
Start codon position: 2
End codon position: 11
Gene: atgctaatt
Part 3 - Decoding the Gene
Problem

Now that you have a gene you might wonder what you can do with it. Many of the things gene sequencing services offer come from analyzing SNPs or single nucleotide polymorphisms. These are one character changes in genes that have a large effect on your body. For example, a single nucleotide can tell us if your eyes are blue, if you have an increased risk for diabetes, or you're lactose intolerant. SNPedia lists 82,000 SNPs we've identified.

Our software will look at single nucleotides in the gene we pulled out and produce a report telling us a person's eye color, hair color and whether or not they can roll their tongue.

Preparation

Look at how to use the switch statement.
Experiment with using a System.out.println after calling System.out.print
What happens?
Why does it happen?
Think about when you concatenated strings earlier in the project. Could you use this there?
Things To Do

This table will show the SNPs we're looking for, the position of the SNP and what the label is for that trait.

Trait	Position	a	t	c	g
Eye Color	20	“blue”	“green”	“brown”	“brown”
Hair Color	18	“black”	“blond”	“brown”	“red”
Can Roll Tongue	8	“yes”	“no”	“no”	“no”
If the gene is less than 30 characters long, print "The gene is not long enough to continue." and return.
Print "Analysis Results"
Find the SNP at position 20, and print out "Eye color: " concatenated with the person's eye color.
Find the SNP at position 18, and print out "Hair color: " concatenated with the person's hair color.
Find the SNP at position 8 and print out "Can roll tongue? " concatenated with whether or not a person can roll their tongue.
Notes

At this point in the program, we know all the characters in the gene will be a, t, c or g
Positions of the gene starts at 0 from the first character of the start codon.
Example

Input lowercase DNA fragments one line at a time. End with a blank line.
atgaccggcagtctatatgactctgatgccgcaggctgcctctga

Input DNA: atgaccggcagtctatatgactctgatgccgcaggctgcctctga
Start codon position: 0
End codon position: 42
Gene: atgaccggcagtctatatgactctgatgccgcaggctgcctc

Analysis Results

Eye color: brown
Hair color: red
Can roll tongue? no
