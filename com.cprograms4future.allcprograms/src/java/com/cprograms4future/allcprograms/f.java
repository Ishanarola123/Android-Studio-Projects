/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.TextView
 *  com.cprograms4future.allcprograms.HelloWorld
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.cprograms4future.allcprograms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cprograms4future.allcprograms.HelloWorld;
import com.cprograms4future.allcprograms.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class f
extends BaseAdapter {
    private ArrayList<h> arraylist;
    LayoutInflater inflater;
    Context mContext;
    private List<h> programslist = null;

    public f(Context context, List<h> list) {
        this.mContext = context;
        this.programslist = list;
        this.inflater = LayoutInflater.from((Context)this.mContext);
        this.arraylist = new ArrayList();
        this.arraylist.addAll(list);
    }

    public void filter(String string) {
        String string2 = string.toLowerCase(Locale.getDefault());
        this.programslist.clear();
        if (string2.length() == 0) {
            this.programslist.addAll(this.arraylist);
        } else {
            for (h h2 : this.arraylist) {
                if (!h2.getProgramName().toLowerCase(Locale.getDefault()).contains((CharSequence)string2)) continue;
                this.programslist.add((Object)h2);
            }
        }
        this.notifyDataSetChanged();
    }

    public int getCount() {
        return this.programslist.size();
    }

    public h getItem(int n2) {
        return (h)this.programslist.get(n2);
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(final int n2, View view, ViewGroup viewGroup) {
        View view2;
        a a2;
        HashMap<String, String> hashMap = new HashMap<String, String>(){
            {
                this.put((Object)"file:///android_asset/hello.html", (Object)"Hello World");
                this.put((Object)"file:///android_asset/prog_2_print_1to100/print_1to100", (Object)"Print 1 to 100");
                this.put((Object)"file:///android_asset/prog3_alphabets_from_A_Z/alphabets_from_A_Z", (Object)"Print Alphabets from A-Z");
                this.put((Object)"file:///android_asset/prog4_small_a_z/small_a_z", (Object)"Print Alphabets from a-z(small)");
                this.put((Object)"file:///android_asset/prog5_print_odd_or_even/prog4_print_odd_or_even", (Object)"To Print whether given number is Odd or Even");
                this.put((Object)"file:///android_asset/prog6_print_n_odd.html", (Object)"To Print all the Odd Numbers till N");
                this.put((Object)"file:///android_asset/prog7_swap_using_third_variablle.html", (Object)"To swap two numbers using 3rd variable");
                this.put((Object)"file:///android_asset/prog8_swap_without_third_variable.html", (Object)"To swap two numbers without using 3rd variable");
                this.put((Object)"file:///android_asset/prog9_print_leap_or_not.html", (Object)"To find if the given year is leap year or not");
                this.put((Object)"file:///android_asset/prog10_totdays_years_week_days.html", (Object)"To convert given days to years,week and days");
                this.put((Object)"file:///android_asset/prog11_biggest_of_three_numbers.html", (Object)"Biggest of Three Numbers");
                this.put((Object)"file:///android_asset/prog12_multiply_using_addition.html", (Object)"Program to print Multiplication by using Addition");
                this.put((Object)"file:///android_asset/prog13_company_bonus.html", (Object)"Program to print Company Bonus on Salary");
                this.put((Object)"file:///android_asset/prog14_basic_pay.html", (Object)"Calculate Gross Salary from given Basic Pay");
                this.put((Object)"file:///android_asset/prog14_sum_n_numbers.html", (Object)"Sum of N Numbers");
                this.put((Object)"file:///android_asset/prog1_1_sum_all_digits.html", (Object)"Sum of all Digits in Number");
                this.put((Object)"file:///android_asset/prog1_2_print_reverse_number.html", (Object)"To print the reverse of a given number");
                this.put((Object)"file:///android_asset/prog_1_3_num_palindrome_or_not.html", (Object)"To find whether given number is palindrome or not");
                this.put((Object)"file:///android_asset/prog1_4_sum_integers_divisible_2.html", (Object)"Sum of all integers divisible by 2 between two numbers");
                this.put((Object)"file:///android_asset/prog1_5_factorial.html", (Object)"Factorial of a number");
                this.put((Object)"file:///android_asset/prog1_6_fibonacci.html", (Object)"Fibonacci Series");
                this.put((Object)"file:///android_asset/prog1_7_prime_or_not.html", (Object)"To know whether given number is Prime or Not");
                this.put((Object)"file:///android_asset/prog1_8_print_all_prime.html", (Object)"Print all prime numbers within given number");
                this.put((Object)"file:///android_asset/prog1_9_armstrong_or_not.html", (Object)"Check Whether number is Armstrong number or not");
                this.put((Object)"file:///android_asset/prog1_10_all_armstrong.html", (Object)"Armstrong numbers between 1 and given number");
                this.put((Object)"file:///android_asset/prog1_11_perfect_or_not.html", (Object)"Check whether number is Perfect number or not");
                this.put((Object)"file:///android_asset/prog1_12_all_perfect.html", (Object)"Perfect numbers between 1 and given number");
                this.put((Object)"file:///android_asset/prog1_13_repeated_digits_check.html", (Object)"Check whether there are repeated digits in given Number");
                this.put((Object)"file:///android_asset/prog1_14_strong_or_not.html", (Object)"Find whether given number is Strong or Not");
                this.put((Object)"file:///android_asset/prog1_15_n_strong_numbers.html", (Object)"Find N Strong Numbers");
                this.put((Object)"file:///android_asset/prog1_16_magic_or_not.html", (Object)"Display whether given number is Magic or Not");
                this.put((Object)"file:///android_asset/prog1_17_magic_till_n.html", (Object)"Display all Magic Numbers till N");
                this.put((Object)"file:///android_asset/prog1_18_max_prime_below_n_number.html", (Object)"Maximum Prime Number below given Number");
                this.put((Object)"file:///android_asset/prog1_19_prime_num_between_two_numbers.html", (Object)"Prime Numbers between 2 given numbers");
                this.put((Object)"file:///android_asset/prog1_20_arrange_zeros_left_ones_left.html", (Object)"Arrange Zeros to left side and Ones right side in Arrays");
                this.put((Object)"file:///android_asset/prog1_21_arrangezeros_rhgt_ones_left.html", (Object)"Arrange Zeros to right side and Ones left side in Arrays");
                this.put((Object)"file:///android_asset/prog2_0_areas_of_all_tri_para_etc.html", (Object)"Areas of Triangle,Square,Circle,Rectangle,Parallelogram");
                this.put((Object)"file:///android_asset/prog2_1_sine_value.html", (Object)"Print Sine value Mathematically");
                this.put((Object)"file:///android_asset/prog2_2_cosine_value.html", (Object)"Print Cosine value Mathematically");
                this.put((Object)"file:///android_asset/prog2_3_quadrant_coordinates.html", (Object)"Find Quadrant of given Co-Ordinates");
                this.put((Object)"file:///android_asset/prog2_4_quadratic_equation_roots.html", (Object)"Roots of Quadratic Equations");
                this.put((Object)"file:///android_asset/prog2_5_calculator.html", (Object)"Calculator");
                this.put((Object)"file:///android_asset/prog2_6_simple_interest.html", (Object)"Calculate Simple Interest in all Ways");
                this.put((Object)"file:///android_asset/prog2_7_calculate_only_simple_interest.html", (Object)"Calculate only Simple Interest");
                this.put((Object)"file:///android_asset/prog2_8_compound_interest.html", (Object)"Calculate Compound Interest");
                this.put((Object)"file:///android_asset/prog2_9_polynomial_equation.html", (Object)"Calculate Polynomial Equation");
                this.put((Object)"file:///android_asset/prog2_10_calculate_permutaion_npr.html", (Object)"Calculate Permutation value nPr");
                this.put((Object)"file:///android_asset/prog2_11_combination_ncr.html", (Object)"Calculate Combination value nCr");
                this.put((Object)"file:///android_asset/prog2_12_multiplicative_inverse.html", (Object)"Multiplicative Inverse of a Number");
                this.put((Object)"file:///android_asset/prog2_13_happy_or_not.html", (Object)"Print whether given Number is Happy or not");
                this.put((Object)"file:///android_asset/prog2_14_happy_till_n.html", (Object)"Program to print all Happy Numbers till N");
                this.put((Object)"file:///android_asset/prog2_15_number_poer_integer.html", (Object)"Check whether the given number is power of an integer or not");
                this.put((Object)"file:///android_asset/prog2_16_mean_varicance_deviation.html", (Object)"Display Mean,Variance and Standard Deviation");
                this.put((Object)"file:///android_asset/prog2_17_display_x_y_simultaneous.html", (Object)"Display X and Y values of Simultaneous Equations");
                this.put((Object)"file:///android_asset/prog2_18_display_asquare_rootab_bsquare.html", (Object)"Display a2+root(ab)+b2");
                this.put((Object)"file:///android_asset/prog2_19_add_2_polynomials.html", (Object)"Add 2 Polynomials");
                this.put((Object)"file:///android_asset/prog2_20_multiply_2_polynomials.html", (Object)"Multiply 2 Polynomials");
                this.put((Object)"file:///android_asset/prog2_21_add_n_polynomials.html", (Object)"Add N Polynomials");
                this.put((Object)"file:///android_asset/prog2_22_dist_between_2_points.html", (Object)"Distance between 2 points");
                this.put((Object)"file:///android_asset/prog2_23_angles_triangle_for_side_lengths.html", (Object)"Find Angles of Triangle for given lengths of sides");
                this.put((Object)"file:///android_asset/prog3_0_sumseries1_12_13.html", (Object)"Sum of Series 1+1/2+1/3+1/4....+1/N");
                this.put((Object)"file:///android_asset/prog3_1_sumseries2_1_12_factorial.html", (Object)"Sum of Series 1/1!+2/2!+3/3!+4/4!....+N/N!");
                this.put((Object)"file:///android_asset/prog3_2_sum_AP.html", (Object)"To find sum of series in Arithmetic Progressions(AP)");
                this.put((Object)"file:///android_asset/prog3_3_GP_series.html", (Object)"To find Sum of GP(Geometric Progressions)");
                this.put((Object)"file:///android_asset/prog3_4_sumseries3_12_22_32_powers.html", (Object)"Sum of Series 1^2+2^2+3^2+......n^2");
                this.put((Object)"file:///android_asset/prog3_5_sumseries4_12_22_32_power_differnece.html", (Object)"Sum of Series 1^2-2^2+3^2-......+n^2");
                this.put((Object)"file:///android_asset/prog3_6_Sum_AP_2.html", (Object)"Display Series in AP along with Sum for given Common difference and Number of Terms");
                this.put((Object)"file:///android_asset/prog3_7_sumseries5_11_22_33_powerfactorial.html", (Object)"Sum Series of 1^1/1!+2^2/2!+3^3/3!.. upto n terms");
                this.put((Object)"file:///android_asset/prog3_8_sumseries_6.html", (Object)"Sum Series (1+(1+2)+(1+2+3)+(1+2+3+4)+......till N)");
                this.put((Object)"file:///android_asset/prog3_9_sumseries_7.html", (Object)"Sum Series (1+(1*2)+(1*2*3)+....till N");
                this.put((Object)"file:///android_asset/prog3_10_series_8.html", (Object)"Generate Series -1,4,-7,10,-13....till N");
                this.put((Object)"file:///android_asset/prog4_0__sum_even_recursion.html", (Object)"Print Sum of Even Numbers in Array using Recursion");
                this.put((Object)"file:///android_asset/prog4_1_binary_search_recursion.html", (Object)"Binary Search using Recurion");
                this.put((Object)"file:///android_asset/prog4_2_bubble_sort_recursion.html", (Object)"Bubble Sort using Recursion");
                this.put((Object)"file:///android_asset/prog4_3_check_repeated_digits_recursion.html", (Object)"Check if Repeated digits are there using Recursion");
                this.put((Object)"file:///android_asset/prog4_4_min_number_recursion.html", (Object)"Find minimum number in given Array using Recursion");
                this.put((Object)"file:///android_asset/prog4_5_factorial_recursion.html", (Object)"Factorial of a number using Recursion");
                this.put((Object)"file:///android_asset/prog4_6_gcd_recursion.html", (Object)"GCD of a number using Recursion");
                this.put((Object)"file:///android_asset/prog5_0vowel_or_not.html", (Object)"To know whether the character is vowel or not");
                this.put((Object)"file:///android_asset/prog5_1_count_vowels.html", (Object)"Count number of vowels in a string");
                this.put((Object)"file:///android_asset/prog5_2_length_string.html", (Object)"To know the length of a string without using string functions");
                this.put((Object)"file:///android_asset/prog5_3_count_words_sentence.html", (Object)"To count number of words in a sentence");
                this.put((Object)"file:///android_asset/prog5_4_vowels_count.html", (Object)"To count vowels in sentence");
                this.put((Object)"file:///android_asset/prog5_5_letter_repeat_count.html", (Object)"To count number of times a letter repeated in sentence");
                this.put((Object)"file:///android_asset/prog5_6_character_frequency.html", (Object)"Calculate Frequency of each character");
                this.put((Object)"file:///android_asset/prog5_7_convert_upper_to_lower_viceversa.html", (Object)"To convert upper to lower and vice versa");
                this.put((Object)"file:///android_asset/prog5_8_count_whitespaces.html", (Object)"To Print number of white spaces in sentence");
                this.put((Object)"file:///android_asset/prog5_9_string_palindrome.html", (Object)"To know whether the given string is Palindrome or not");
                this.put((Object)"file:///android_asset/prog5_10_reverse_string.html", (Object)"To print the reverse of given string");
                this.put((Object)"file:///android_asset/prog5_11_concatenate_string.html", (Object)"Concatenate two strings");
                this.put((Object)"file:///android_asset/prog5_12_count_vowels_consonants_etc.html", (Object)"Count vowels,consonants,digits and special characters");
                this.put((Object)"file:///android_asset/prog5_13_search_substring.html", (Object)"Search a substring in a given string");
                this.put((Object)"file:///android_asset/prog5_14_compare_strings.html", (Object)"Compare two strings");
                this.put((Object)"file:///android_asset/prog5_15_sum_digits_string.html", (Object)"To print sum of digits in string");
                this.put((Object)"file:///android_asset/prog5_16_first_capital_letter.html", (Object)"To find the first capital letter in a given string");
                this.put((Object)"file:///android_asset/prog5_17_split_sentence.html", (Object)"Split sentence for a given character");
                this.put((Object)"file:///android_asset/prog5_18_sort_names.html", (Object)"Sort names in Alphabetical order");
                this.put((Object)"file:///android_asset/prog5_19_reverse_words.html", (Object)"Reverse of Words in Given String");
                this.put((Object)"file:///android_asset/prog5_20_largerst_smallest_word.html", (Object)"Print Largest and Smallest Word from given Sentence");
                this.put((Object)"file:///android_asset/prog5_21_largest_smallest_palindrome.html", (Object)"Print Largest and Smallest Palindrome in Sentence");
                this.put((Object)"file:///android_asset/prog5_22_circular_permuted.html", (Object)"Circularly Permuted String for n number of times");
                this.put((Object)"file:///android_asset/prog5_23_remove_repeated.html", (Object)"Remove Repeated Words in String");
                this.put((Object)"file:///android_asset/prog5_24_replace_substring_given_string.html", (Object)"Replace the Substring with the given String");
                this.put((Object)"file:///android_asset/prog5_25_limit_characters.html", (Object)"Limit number of Characters entered by User");
                this.put((Object)"file:///android_asset/prog5_26_words_consecutive_vowels.html", (Object)"Words with Consecutive Vowels in Sentence");
                this.put((Object)"file:///android_asset/prog5_27_subset_words.html", (Object)"Find Subsets of Given String");
                this.put((Object)"file:///android_asset/prog5_28_letters_repeated_more.html", (Object)"Letters which are repeated more number of time");
                this.put((Object)"file:///android_asset/prog5_29_string1_present_string2.html", (Object)"Check whether all Characters from String 1 matches String 2");
                this.put((Object)"file:///android_asset/prog5_30_first_small_letter.html", (Object)"Find First Small Letter in String");
                this.put((Object)"file:///android_asset/prog5_31_find_words_ended_character.html", (Object)"Find All Words ended with given Character");
                this.put((Object)"file:///android_asset/prog5_32_char_need_palindrome.html", (Object)"Number of Characters need to make a String Palindrome");
                this.put((Object)"file:///android_asset/prog5_33_anagrams_or_not.html", (Object)"Anagrams or Not");
                this.put((Object)"file:///android_asset/prog5_34_ascii_letters.html", (Object)"Print ASCII Values of letters in string");
                this.put((Object)"file:///android_asset/prog5_35_ascii_letters_of_next_character.html", (Object)"Print ASCII value of given Character and Print its next character");
                this.put((Object)"file:///android_asset/prog5_36_rev_num_in_words.html", (Object)"Display Reverse of Number in words");
                this.put((Object)"file:///android_asset/prog5_37_rev_num_words_separate.html", (Object)"Reverse of Given Number in words separate digits");
                this.put((Object)"file:///android_asset/prog5_38_swap_2_strings_without_string.html", (Object)"Swap 2 Strings without String Library functions");
                this.put((Object)"file:///android_asset/prog5_38_swap_2_strings.html", (Object)"Swap 2 Strings");
                this.put((Object)"file:///android_asset/prog5_39_all_palindromes_all_non_palindromes.html", (Object)"Display All Palindromes and Non-Palindromes in a given sentence");
                this.put((Object)"file:///android_asset/prog6_0_length_string_library.html", (Object)"Print length of a string using string functions");
                this.put((Object)"file:///android_asset/prog6_1_upper_lower_viceversa.html", (Object)"Convert Upper to Lower and Vice Vesra using Library Functions");
                this.put((Object)"file:///android_asset/prog6_2_reverse_string.html", (Object)"Print Reverse of given string using Library Functions");
                this.put((Object)"file:///android_asset/prog6_3_palindrome_library_string.html", (Object)"String Palindrome using Library Functions");
                this.put((Object)"file:///android_asset/prog6_4_string_compare_library.html", (Object)"String Comparision using Library Functions");
                this.put((Object)"file:///android_asset/prog6_5_occurance_word_library.html", (Object)"Display Occurance of Word using Library Functions");
                this.put((Object)"file:///android_asset/prog7_0_decimal_binary.html", (Object)"Decimal to Binary");
                this.put((Object)"file:///android_asset/prog7_1_binary_decimal.html", (Object)"Binary to Decimal");
                this.put((Object)"file:///android_asset/prog7_2_roman_decimal.html", (Object)"Roman to Decimal");
                this.put((Object)"file:///android_asset/prog7_3_decimal_octal.html", (Object)"Decimal to Octal");
                this.put((Object)"file:///android_asset/prog7_4_octal_decimal.html", (Object)"Octal to Decimal");
                this.put((Object)"file:///android_asset/prog7_5_celcius_farenheit.html", (Object)"Celsius to Fahrenheit");
                this.put((Object)"file:///android_asset/prog7_6_fahrenheit_celcius.html", (Object)"Fahrenheit to Celsius");
                this.put((Object)"file:///android_asset/prog7_7_currency_spped_conversion.html", (Object)"Currency Length Speed Conversions");
                this.put((Object)"file:///android_asset/prog7_8_allinone_conversion.html", (Object)"All in One Conversion");
                this.put((Object)"file:///android_asset/prog7_9_binary_octal.html", (Object)"Binary to Octal");
                this.put((Object)"file:///android_asset/prog7_10_octal_binary.html", (Object)"Octal to Binary");
                this.put((Object)"file:///android_asset/prog7_11_binary_hexa.html", (Object)"Binary to HexaDecimal");
                this.put((Object)"file:///android_asset/prog8_0_average_class.html", (Object)"Find Average of Class using arrays");
                this.put((Object)"file:///android_asset/prog8_1_neg_pos.html", (Object)"Find Sum of Negative and Positive integers in arrays");
                this.put((Object)"file:///android_asset/prog8_2_min_max.html", (Object)"Minimum and Maximum of given numbers in arrays");
                this.put((Object)"file:///android_asset/prog8_3_max_2_num.html", (Object)"Find first 2 maximum numbers in array");
                this.put((Object)"file:///android_asset/prog8_4_even_odd_separate.html", (Object)"To separate even and odd numbers in an array");
                this.put((Object)"file:///android_asset/prog8_5_deleted_element.html", (Object)"Delete a specified integer in array");
                this.put((Object)"file:///android_asset/prog8_6_insert_element.html", (Object)"Insert an element into an array at a specified position");
                this.put((Object)"file:///android_asset/prog8_7_remove_repeated_array.html", (Object)"To Remove repeated elements in an Array");
                this.put((Object)"file:///android_asset/prog8_8_merge_arrays.html", (Object)"Merge Two Arrays in sorted order");
                this.put((Object)"file:///android_asset/prog8_9_union_intersection.html", (Object)"To print Union and Intersection of given Array");
                this.put((Object)"file:///android_asset/prog8_10_arraypair_sum_equal_number.html", (Object)"Display Array Pairs whose Sum is equal to a Number");
                this.put((Object)"file:///android_asset/prog8_11_largest_diff_bet_array_ele.html", (Object)"Print the largest difference between two array elements");
                this.put((Object)"file:///android_asset/prog8_12_avg_no_even_position.html", (Object)"Print Average of Numbers in Array at Even Positions");
                this.put((Object)"file:///android_asset/prog8_13_array_rev_swap_method.html", (Object)"Print Array elements in Reverse Order using Swapping method");
                this.put((Object)"file:///android_asset/prog8_14_array_pair_near_zero.html", (Object)"Array Pair which when added will give nearest zero");
                this.put((Object)"file:///android_asset/prog8_15_odd_times_repeated_array.html", (Object)"Numbers repeated Odd number of times in array");
                this.put((Object)"file:///android_asset/prog8_16_frequency_array_numbers.html", (Object)"Frequency of all numbers in array");
                this.put((Object)"file:///android_asset/prog8_17_avg_best2testmarks.html", (Object)"Average of best two test marks out of given number of test marks");
                this.put((Object)"file:///android_asset/prog8_18_sum_n_numbers_array.html", (Object)"Sum of N Numbers in Array");
                this.put((Object)"file:///android_asset/prog9_0_linear_search.html", (Object)"Linear Search");
                this.put((Object)"file:///android_asset/prog9_1_binary_search_with_unsorted_input.html", (Object)"Binary Search with input of any order");
                this.put((Object)"file:///android_asset/prog9_2_binary_search_sorted_input.html", (Object)"Binary Search with input as sorted order");
                this.put((Object)"file:///android_asset/prog10_0_sort_ascending.html", (Object)"Sort Array in Ascending Order");
                this.put((Object)"file:///android_asset/prog10_1_sort_descending.html", (Object)"Sort Array in Descending Order");
                this.put((Object)"file:///android_asset/prog10_2_bubble_sort.html", (Object)"Sort Array using Bubble Sort");
                this.put((Object)"file:///android_asset/prog10_3_insertion_sort.html", (Object)"Insertion Sort(Ascending order)");
                this.put((Object)"file:///android_asset/prog10_4_selection_sort.html", (Object)"Selection Sort");
                this.put((Object)"file:///android_asset/prog10_5_oddeven_sort.html", (Object)"Odd Even Sort");
                this.put((Object)"file:///android_asset/prog10_6_row_col_ascnding.html", (Object)"Arrange Rows and Columns of Matrix in Ascending order");
                this.put((Object)"file:///android_asset/prog10_7_row_col_asc2.html", (Object)"Arrange Rows and Columns in Ascending order (Method II)");
                this.put((Object)"file:///android_asset/prog10_8_row_col_desc.html", (Object)"Arrange Rows and Columns of Matrix in Descending order");
                this.put((Object)"file:///android_asset/prog10_9_row_asc_col_desc.html", (Object)"Arrange Rows in Ascending and Columns in Descending order");
                this.put((Object)"file:///android_asset/prog10_10_quicksort.html", (Object)"Quick Sort");
                this.put((Object)"file:///android_asset/prog11_0_add_2_matrices.html", (Object)"Addition of 2 Matrices");
                this.put((Object)"file:///android_asset/prog11_1_diff_2_matrices.html", (Object)"Difference of 2 Matrices");
                this.put((Object)"file:///android_asset/prog11_2_mul_2_matrices.html", (Object)"Multiplication of 2 Matrices");
                this.put((Object)"file:///android_asset/prog11_3_add_n_matrices.html", (Object)"Add N Matrices");
                this.put((Object)"file:///android_asset/prog11_4_diff_n_matrices.html", (Object)"Difference N Matrices");
                this.put((Object)"file:///android_asset/prog11_5_mul_n_matrices.html", (Object)"Multiply N Matrices");
                this.put((Object)"file:///android_asset/prog11_6_compare_matrices.html", (Object)"Compare 2 Matrices");
                this.put((Object)"file:///android_asset/prog11_7_transpose_matrix.html", (Object)"Transpose of given Matrix");
                this.put((Object)"file:///android_asset/prog11_8_trace_matrix.html", (Object)"Trace of a given Matrix");
                this.put((Object)"file:///android_asset/prog11_9_matrix_identity.html", (Object)"Find whether given Matrix is Identity or not");
                this.put((Object)"file:///android_asset/prog11_10_sum_row_col_matrix.html", (Object)"To find sum of rows and columns in a matrix");
                this.put((Object)"file:///android_asset/prog11_11_sum_col_goto.html", (Object)"Print sum of Columns in matrix using GOTO Statement");
                this.put((Object)"file:///android_asset/prog11_12_sum_diagonal.html", (Object)"Find Sum of all Diagonals in a matrix");
                this.put((Object)"file:///android_asset/prog11_13_sparse_matrix.html", (Object)"Find whether given matrix is Sparse Matrix or not");
                this.put((Object)"file:///android_asset/prog11_14_normal_matrix.html", (Object)"Find Normal of Given matrix");
                this.put((Object)"file:///android_asset/prog11_15_upper_lower_triangle_matrix.html", (Object)"Display Upper and Lower Triangle of given Matrix");
                this.put((Object)"file:///android_asset/prog11_16_sum_upper_lower_triangle_matrix.html", (Object)"Sum of Upper and Lower Triangle of Matrix");
                this.put((Object)"file:///android_asset/prog11_17_interchange_diagonals.html", (Object)"Interchange Diagonals in Matrix");
                this.put((Object)"file:///android_asset/prog11_18_orthogonal_or_not.html", (Object)"Check whether given Matrix is Orthogonal or not");
                this.put((Object)"file:///android_asset/prog11_19_matrix_equal_or_not.html", (Object)"Check Whether Both Matrices are Equal or not");
                this.put((Object)"file:///android_asset/prog12_0_automatic.html", (Object)"Automatic Storage Class");
                this.put((Object)"file:///android_asset/prog12_1-register.html", (Object)"Register Storage Class");
                this.put((Object)"file:///android_asset/prog12_2_static.html", (Object)"Voting System using Static Storage Class");
                this.put((Object)"file:///android_asset/prog12_3_external.html", (Object)"External Storage Class");
                this.put((Object)"file:///android_asset/prog13_0_variables_value_pointer.html", (Object)"Printing Values in Variables using pointers");
                this.put((Object)"file:///android_asset/prog13_1_swap_pointer.html", (Object)"Swap two numbers using pointers");
                this.put((Object)"file:///android_asset/prog13_2_copy_string_pointer.html", (Object)"Copy one string to other String using Pointers");
                this.put((Object)"file:///android_asset/prog13_3_length_string_pointer.html", (Object)"Print length of a string using pointers");
                this.put((Object)"file:///android_asset/prog13_4_concatenate_pointer.html", (Object)"Concatenate two Strings using pointers");
                this.put((Object)"file:///android_asset/prog13_5_compare_string_pointer.html", (Object)"Compare two Strings using pointers");
                this.put((Object)"file:///android_asset/prog13_6_inc_array_pointer.html", (Object)"Print values in array by incrementing pointer");
                this.put((Object)"file:///android_asset/prog13_7_dec_array_pointer.html", (Object)"Print values in array by decrementing pointer");
                this.put((Object)"file:///android_asset/prog13_8_char_array_pointer.html", (Object)"Printing Character Array");
                this.put((Object)"file:///android_asset/prog13_9_sum_array_num_pointer.html", (Object)"Sum of Numbers in Array using Pointer");
                this.put((Object)"file:///android_asset/prog13_10_n_char_pointer.html", (Object)"Print N Characters from given Position of a string");
                this.put((Object)"file:///android_asset/prog13_11_add_matrix_pointers.html", (Object)"Addition of 2 Matrices using Pointers");
                this.put((Object)"file:///android_asset/prog13_12_subtract_matrix_pointers.html", (Object)"Subtraction of 2 Matrices using Pointers");
                this.put((Object)"file:///android_asset/prog14_0_simple_structure.html", (Object)"Simple Structure");
                this.put((Object)"file:///android_asset/prog14_1_simple_structure2.html", (Object)"Simple Structure 2");
                this.put((Object)"file:///android_asset/prog14_2_structure_pointer.html", (Object)"Structure Pointer");
                this.put((Object)"file:///android_asset/prog14_3_structure_array.html", (Object)"Structure Array");
                this.put((Object)"file:///android_asset/prog14_4_structure_func.html", (Object)"Structure using Function");
                this.put((Object)"file:///android_asset/prog14_5_complex_n_structures.html", (Object)"Add N Complex Numbers using Structures");
                this.put((Object)"file:///android_asset/prog14_6_marks_n_students_m_subjects.html", (Object)"Total Marks for N students for M subjects");
                this.put((Object)"file:///android_asset/prog15_0_single_linked_list.html", (Object)"Single Linked List");
                this.put((Object)"file:///android_asset/prog15_1_linked_list_names.html", (Object)"Single Linked List for linking Names");
                this.put((Object)"file:///android_asset/prog15_2_stacks_arrays.html", (Object)"Stacks using Arrays");
                this.put((Object)"file:///android_asset/prog16_0_read_file.html", (Object)"Reading a File and Printing on console");
                this.put((Object)"file:///android_asset/prog16_1_write_files.html", (Object)"Writing into a File");
                this.put((Object)"file:///android_asset/prog16_2_append_text.html", (Object)"Append Text into File");
                this.put((Object)"file:///android_asset/prog16_3_sum_int_file.html", (Object)"Print Sum of Integers in Files");
                this.put((Object)"file:///android_asset/prog16_4_count_tabs_spaces_file.html", (Object)"Print Number of Spaces,Lines,characters,tabs in File");
                this.put((Object)"file:///android_asset/prog16_5_copy_file_another.html", (Object)"Copy Text from one file to other");
                this.put((Object)"file:///android_asset/prog16_6_lucky_winner.html", (Object)"Lucky Winner(Application)");
                this.put((Object)"file:///android_asset/prog16_7_contact_files.html", (Object)"Store Contacts in Text File");
                this.put((Object)"file:///android_asset/prog16_8_Agenda_text_file.html", (Object)"Program to prepare Agenda(Events on a particular day) and Store in file(Application)");
                this.put((Object)"file:///android_asset/prog16_9_separate_odd_even_file.html", (Object)"Create a file with a set of numbers and write Odd and Even numbers into separate files");
                this.put((Object)"file:///android_asset/prog16_10_location_of_running_program.html", (Object)"Print Loaction of running Program");
                this.put((Object)"file:///android_asset/prog16_11_own_sorce_code.html", (Object)"Printing program's own Source Code");
                this.put((Object)"file:///android_asset/prog16_12_merge_2_files.html", (Object)"Merge 2 files into another file");
                this.put((Object)"file:///android_asset/prog16_13_merge_n_files.html", (Object)"Merge N given files into another file");
                this.put((Object)"file:///android_asset/prog17_0_floyyds.html", (Object)"Floyyds Triangle");
                this.put((Object)"file:///android_asset/prog17_2_number_diamond.html", (Object)"Number Diamond");
                this.put((Object)"file:///android_asset/prog17_1_number_pyramid_1_232.html", (Object)"Number Pyramid");
                this.put((Object)"file:///android_asset/prog17_3_number_diamond_2.html", (Object)"Number Diamond II");
                this.put((Object)"file:///android_asset/prog17_5_right_angle_pattern1_22_333.html", (Object)"1\n22\n333\n4444");
                this.put((Object)"file:///android_asset/prog17_4_pascals_triangle.html", (Object)"Pascals Triangle");
                this.put((Object)"file:///android_asset/prog17_6_right_angle_pattern2_1_12_123.html", (Object)"1\n12\n123");
                this.put((Object)"file:///android_asset/prog17_7_numerical_pattern_1_111_222_333.html", (Object)"1111\n2222\n3333\n4444");
                this.put((Object)"file:///android_asset/prog17_8_numerical_pattern_2_123_123_123.html", (Object)"1234\n1234\n1234\n1234");
                this.put((Object)"file:///android_asset/prog17_9_reverse_right_angle1_4321_321_21_1.html", (Object)"4321\n321\n21\n1");
                this.put((Object)"file:///android_asset/prog17_10_reverse_right_2_1234_123_12_1.html", (Object)"1234\n123\n12\n1");
                this.put((Object)"file:///android_asset/prog17_11_rev_pat_3_111_22_3.html", (Object)"1111\n222\n33\n4");
                this.put((Object)"file:///android_asset/prog17_12_rev_rigt_pat4_333_22_1.html", (Object)"4444\n333\n22\n1");
                this.put((Object)"file:///android_asset/prog17_13_num_patt_4_consecutive_numbers.html", (Object)"1\n2 6\n3 7 10\n4 8 11 13\n5 9 12 14 15");
                this.put((Object)"file:///android_asset/prog17_14_num_pat6_1_23_357.html", (Object)"\t\t\t\t\t1\n\t\t\t2  3\n\t3  5  7");
                this.put((Object)"file:///android_asset/prog17_15_number_x_pat.html", (Object)"1\t\t\t1\n\t2\t2\n\t\t3\n\t4\t4\n5\t\t\t5");
                this.put((Object)"file:///android_asset/prog17_16_rev_number_x_pat.html", (Object)"5\t\t\t5\n\t4\t4\n\t\t3\n\t2\t2\n1\t\t\t1");
                this.put((Object)"file:///android_asset/prog17_17_spiral_pat.html", (Object)"1\t\t\t2\n4\t\t\t3\t\t\t\t\t\t\t\tSpiral Pattern\n5\t\t\t6\n8\t\t\t7");
                this.put((Object)"file:///android_asset/prog17_18_misc_num_pat1.html", (Object)"1234\n\t123\n\t\t12\n\t\t\t1");
                this.put((Object)"file:///android_asset/prog17_19_mis_num_pat2.html", (Object)"4444\n\t333\n\t\t22\n\t\t\t1");
                this.put((Object)"file:///android_asset/prog17_20_mis_num_pat3.html", (Object)"\t\t\t1\n\t\t12\n\t123\n1234");
                this.put((Object)"file:///android_asset/prog17_21_misc_num_pat4.html", (Object)"\t\t\t1\n\t\t22\n\t333\n4444");
                this.put((Object)"file:///android_asset/prog17_22_mis_num_pat5.html", (Object)"1\n21\n321\n4321");
                this.put((Object)"file:///android_asset/prog17_23_1_21_321_right.html", (Object)"\t\t\t1\n\t\t21\n\t321\n4321");
                this.put((Object)"file:///android_asset/prog17_24_numerical_hollow_parallelogram.html", (Object)"Numerical Hollow Parallelogram pattern");
                this.put((Object)"file:///android_asset/prog18_0_alpha_pat_1_a_bb_ccc.html", (Object)"A\nBB\nCCC\nDDDD");
                this.put((Object)"file:///android_asset/prog18_1_alpha_pat2_a_ab_abc.html", (Object)"A\nAB\nABC\nABCD");
                this.put((Object)"file:///android_asset/prog18_2_alp_pat3_aaa_bbb_ccc.html", (Object)"AAAA\nBBBB\nCCCC\nDDDD");
                this.put((Object)"file:///android_asset/prog18_3_alp_pat4_abc_abc_abc.html", (Object)"ABCD\nABCD\nABCD\nABCD");
                this.put((Object)"file:///android_asset/prog18_4_rev_alph_pat1_abc_ab_a.html", (Object)"ABCD\nABC\nAB\nA");
                this.put((Object)"file:///android_asset/prog18_5_rev_alph_pat2_aaa_bb_c.html", (Object)"AAAA\nBBB\nCC\nD");
                this.put((Object)"file:///android_asset/prog18_6_rev_alpha_pat4_dddd_ccc_bb_a.html", (Object)"DDDD\nCCC\nBB\nA");
                this.put((Object)"file:///android_asset/prog18_6_rev_alp_3_cba_cb_c.html", (Object)"DCBA\nDCB\nDC\nD");
                this.put((Object)"file:///android_asset/prog18_8_alpha_x_pattern.html", (Object)"c\t\t\tc\n\tp\tp\n\t\tr\n\to\to\ng\t\t\tg");
                this.put((Object)"file:///android_asset/prog18_10_string_symbol_pattern.html", (Object)"*\t\t\t\t\t\t*\n*\t*\t\t\t*\t\t*\n*\t\t\t*\t\t\t*\n*\t\t\t\t\t\t*\n*\t\t\t\t\t\t*");
                this.put((Object)"file:///android_asset/prog18_9_rev_x_pat.html", (Object)"g\t\t\tg\n\to\to\n\t\tr\n\tp\tp\nc\t\t\tc");
                this.put((Object)"file:///android_asset/prog18_11_rev_v_patt.html", (Object)"ABCDCBA\nABC\t CBA\nAB\t\t\t\t\tBA\nA\t\t\t\t\t\t\t A");
                this.put((Object)"file:///android_asset/prog18_12_spiral_alpha.html", (Object)"A\tB\nD\tC\t\t\t\t\t\t\tSpiral Pattern\nE\tF\nH\tG");
                this.put((Object)"file:///android_asset/prog18_13_alpha_pat6_a_cb_fed.html", (Object)"\t\t\tA\n\t\tCB\n\tFED\nJIHG");
                this.put((Object)"file:///android_asset/prog18_14_mis_alpha_pat1.html", (Object)"ABCD\n\tABC\n\t\t AB\n\t\t\t A");
                this.put((Object)"file:///android_asset/prog18_15_mis_alpha_pat2.html", (Object)"DDDD\n\t CCC\n\t\t BB\n\t\t\t A");
                this.put((Object)"file:///android_asset/prog18_16_mis_alpha_pat3.html", (Object)"AAAA\n\tBBB\n\t\tCC\n\t\t\tD");
                this.put((Object)"file:///android_asset/prog18_17_mis_alpha_pat4.html", (Object)"\t\t\tA\n\t\tAB\n\tABC\nABCD");
                this.put((Object)"file:///android_asset/prog18_18_mis_alpha_pat5.html", (Object)"\t\t\tA\n\t\tBB\n\tCCC\nDDDD");
                this.put((Object)"file:///android_asset/prog18_19_mis_alpha_num.html", (Object)"1\nAA\n222\nBBBB");
                this.put((Object)"file:///android_asset/prog18_20_alpha_hollo_pattern.html", (Object)"Alphabetical Hollow Paralellogram Pattern");
                this.put((Object)"file:///android_asset/prog19_0_symbol_diamond_3rows.html", (Object)"\t\t*\n\t***\n*****\n\t***\n\t\t*");
                this.put((Object)"file:///android_asset/prog_19_1_symbol_diamond.html", (Object)"Symbol Diamond for N Rows");
                this.put((Object)"file:///android_asset/prog19_2_symbol_pattern1.html", (Object)"****\n****\n****\n****");
                this.put((Object)"file:///android_asset/prog19_3_symbol_pattern_2.html", (Object)"*\n**\n***\n****");
                this.put((Object)"file:///android_asset/prog19_4_symbol_patt_3.html", (Object)"****\n***\n**\n*");
                this.put((Object)"file:///android_asset/prog19_5_symbol_pat4.html", (Object)"****\n\t***\n\t\t**\n\t\t\t*");
                this.put((Object)"file:///android_asset/prog19_6_symbol_pat5.html", (Object)"\t\t\t*\n\t\t**\n\t***\n****");
                this.put((Object)"file:///android_asset/prog19_7_symbol_pat_rev_v.html", (Object)"*******\n***\t ***\n**\t\t\t **\n*\t\t\t\t\t *");
                this.put((Object)"file:///android_asset/prog19_8_symbol_x_pattern.html", (Object)"*\t\t\t*\n\t*\t*\n\t *\n\t*\t*\n*\t\t\t*");
                this.put((Object)"file:///android_asset/prog19_9_symbol_hollow_parallelogram.html", (Object)"Symbol Hollow Parallelogram Pattern");
                this.put((Object)"file:///android_asset/prog19_10_symbol_hollow_square.html", (Object)"Symbol Hollow Square Pattern");
                this.put((Object)"file:///android_asset/prog19_11_symbol_steps_pattern.html", (Object)"Symbol Steps Pattern");
                this.put((Object)"file:///android_asset/prog19_12_left_rev_symbol_step.html", (Object)"Left Reverse Symbol Steps Pattern");
                this.put((Object)"file:///android_asset/prog19_13_right_symbol_steps.html", (Object)"Right Symbol Steps Pattern");
                this.put((Object)"file:///android_asset/prog19_14_right_rev_symbol_step.html", (Object)"Right Reverse Symbol Steps Pattern");
                this.put((Object)"file:///android_asset/prog19_15_left_v_symbol.html", (Object)"*****\n****\n***\n**\n*\n*\n**\n***\n****\n*****\n");
                this.put((Object)"file:///android_asset/prog20_0_symb_pyramid.html", (Object)"\t\t\t*\n\t\t***\n\t*****\n*******");
                this.put((Object)"file:///android_asset/prog20_1_rev_symb_pyramid.html", (Object)"*******\n\t*****\n\t\t***\n\t\t\t*");
                this.put((Object)"file:///android_asset/prog20_2_left_sym_pyramid.html", (Object)"*\n*\t\t*\n*\t\t*\t\t*\n*\t\t*\t\t*\t\t*\n*\t\t*\t\t*\n*\t\t*\n*");
                this.put((Object)"file:///android_asset/prog20_3_right_sym_pyramid.html", (Object)"\t\t\t*\n\t\t**\n\t***\n****\n\t***\n\t\t**\n\t\t\t*");
                this.put((Object)"file:///android_asset/prog21_0_alpha_pyramid1.html", (Object)"\t\t\t A\n\t\t BBB\n\t CCCCC\nDDDDDDD");
                this.put((Object)"file:///android_asset/prog21_1_alpha_pyramid2.html", (Object)"AAAAAAA\n\t\tBBBBB\n\t\t\tCCC\n\t\t\t\t D");
                this.put((Object)"file:///android_asset/prog21_2_left_alpha_pyramid.html", (Object)"A\nB\tB\nC\tC\tC\nD\tD\tD\tD\nC\tC\tC\nB\tB\nA");
                this.put((Object)"file:///android_asset/prog21_3_right_alpha_pyramid.html", (Object)"\t\t\t\t\tA\n\t\t\tB\tB\n\tC\tC\tC\n\t\t\tB\tB\n\t\t\t\t\tA");
                this.put((Object)"file:///android_asset/prog21_4_alpha_pyramid_2.html", (Object)"\t\t\t\tA\n\t\t\tBCD\n\t\tEFGHI\nJKLMNOP");
                this.put((Object)"file:///android_asset/prog21_5_rev_alpha_pyramid2.html", (Object)"ABCDE\n\t FGH\n\t\t\tI");
                this.put((Object)"file:///android_asset/prog21_6_left_alpha_pyramid2.html", (Object)"A\nB C\nD E F\nG H I J\nK L M\nN O\nP");
                this.put((Object)"file:///android_asset/prog21_7_right_alpha_pyramid2.html", (Object)"\t\t\t\t\tA\n\t\t\tB\tC\n\tD\tE\tF\n\t\t\tG\tH\n\t\t\t\t\tI");
                this.put((Object)"file:///android_asset/prog21_8_alpha_pyramid_3.html", (Object)"\t\t\tA\n\t\tABC\n\tABCDE\nABCDEFG");
                this.put((Object)"file:///android_asset/prog21_9_alpha_pyramid_3.html", (Object)"ABCDEFG\n\t ABCDE\n\t\t\tABC\n\t\t\t\t A");
                this.put((Object)"file:///android_asset/prog21_10_left_alpha_pyramid3.html", (Object)"A\nA B\nA B C\nA B\nA");
                this.put((Object)"file:///android_asset/prog21_11_right_alpha_pyramid_3.html", (Object)"\t\t\t\t\tA\n\t\t\tA\tB\n\tA\tB\tC\n\t\t\tA\tB\n\t\t\t\t\tA");
                this.put((Object)"file:///android_asset/prog21_12_alpha_pyramid4.html", (Object)"\t\t\tA\n\t BCB\nCDEDC");
                this.put((Object)"file:///android_asset/prog21_13_rev_alpha_pyramid4.html", (Object)"ABCBA\n\tABA\n\t\tA");
                this.put((Object)"file:///android_asset/prog21_14_left_alpha_pyramid_4.html", (Object)"D\nD C\nD C B\nD C B A\nD C B\nD C\nD");
                this.put((Object)"file:///android_asset/prog21_15_alpha_pyramid_5.html", (Object)"\t\t\tA\n\t\tABA\n\tABCAB\nABCDABC");
                this.put((Object)"file:///android_asset/prog21_16_rev_alpha_pyramid_5.html", (Object)"ABCDABC\n\t ABCAB\n\t\t\tABA\n\t\t\t\t A");
                this.put((Object)"file:///android_asset/prog21_17_sand_glass_pat1.html", (Object)"Sand Glass Pattern I");
                this.put((Object)"file:///android_asset/prog21_18_sand_glass_pat2.html", (Object)"Sand Glass Pattern II");
                this.put((Object)"file:///android_asset/prog21_19_alpha_pyramid_4.html", (Object)"\t\t\t Z\n\t\t YZY\n\t XYZYX\nWXYZYXW");
                this.put((Object)"file:///android_asset/prog22_0_num_pyramid_1.html", (Object)"\t\t\t1\n\t\t222\n\t33333\n4444444");
                this.put((Object)"file:///android_asset/prog22_1_rev_num_pyramid_1.html", (Object)"1111111\n\t 22222\n\t\t 333\n\t\t\t 4");
                this.put((Object)"file:///android_asset/prog22_2_left_num_pyramid1.html", (Object)"1\n2 2\n3 3 3\n2 2\n1");
                this.put((Object)"file:///android_asset/prog22_3_right_num_pyramid1.html", (Object)"\t\t1\n\t22\n333\n\t22\n\t\t1");
                this.put((Object)"file:///android_asset/prog22_4_num_pyramid_2.html", (Object)"\t\t\t1\n\t\t123\n\t12345\n1234567");
                this.put((Object)"file:///android_asset/prog22_5_rev_num_pyramid_2.html", (Object)"1234567\n\t12345\n\t\t123\n\t\t\t1");
                this.put((Object)"file:///android_asset/prog22_6_left_pyramid2.html", (Object)"1\n1 2\n1 2 3\n1 2\n1");
                this.put((Object)"file:///android_asset/prog22_7_right_num_pyramid2.html", (Object)"\t\t1\n\t12\n123\n\t12\n\t\t1");
                this.put((Object)"file:///android_asset/prog22_8_num_pyramid_3.html", (Object)"\t\t\t 1\n\t\t 121\n\t12321\n1234321");
                this.put((Object)"file:///android_asset/prog22_9_rev_pyramid_3.html", (Object)"1234321\n\t12321\n\t\t 121\n\t\t\t 1");
                this.put((Object)"file:///android_asset/prog22_10_left_num_pyramid3.html", (Object)"4\n3 3\n2 2 2\n1 1 1 1\n2 2 2\n3 3\n4");
                this.put((Object)"file:///android_asset/prog22_11_ev_binary_pyramid.html", (Object)"0101010\n\t10101\n\t\t010\n\t\t\t1");
                this.put((Object)"file:///android_asset/prog22_12_bin_pyramid.html", (Object)"\t\t\t1\n\t\t010\n\t10101\n0101010");
                this.put((Object)"file:///android_asset/prog22_13_num_sand_glass_patt.html", (Object)"Number Sand Glass Pattern");
                this.put((Object)"file:///android_asset/prog22_14_left_tensmultiple_pyrmaid.html", (Object)"1\n10\n100\n1000\n10000\n1000\n100\n10\n1");
                this.put((Object)"file:///android_asset/prog22_15_misc_numerical_pattern5.html", (Object)"\t\t\t 1\n\t\t 212\n\t 32123\n4321234");
                this.put((Object)"file:///android_asset/prog23_0_number_guessing.html", (Object)"Number Guessing Game");
                this.put((Object)"file:///android_asset/prog23_1_tic_tac_toe.html", (Object)"TIC-TAC-TOE Game");
                this.put((Object)"file:///android_asset/prog23_2_towrs_hanoi.html", (Object)"Towers of Hanoi");
                this.put((Object)"file:///android_asset/prog23_3_guess_toss_coin.html", (Object)"Guess the Toss of Coin");
                this.put((Object)"file:///android_asset/prog23_4_hand_cricket.html", (Object)"Hand Cricket");
                this.put((Object)"file:///android_asset/prog23_5_magic_square.html", (Object)"Magic Square");
                this.put((Object)"file:///android_asset/prog23_6_check_magic_square.html", (Object)"Check Magic Square or Not");
                this.put((Object)"file:///android_asset/prog24_0_area_circum_circle_macro.html", (Object)"Area and Circumference of Circle using Macro Substituion");
                this.put((Object)"file:///android_asset/prog24_1_all_mathematical_operation_macro.html", (Object)"All Mathematical Operation using Macro Substituion");
                this.put((Object)"file:///android_asset/prog25_0_multiplication_table.html", (Object)"Multiplication Table");
                this.put((Object)"file:///android_asset/prog25_1_tell_me_date_i_will_tell_u_day.html", (Object)"Tell me any Date ,I will tell you the Day");
                this.put((Object)"file:///android_asset/prog25_2_time_elapsed_from_january.html", (Object)"Program to Read a Date and print the number of days elapsed from 1st January of the given year");
                this.put((Object)"file:///android_asset/prog25_3_wall_clock_method_1.html", (Object)"Wall Clock Program Method I");
                this.put((Object)"file:///android_asset/prog25_4_wallclock2.html", (Object)"Wall Clock Program Method II");
                this.put((Object)"file:///android_asset/prog25_5_html_shutdown-restart.html", (Object)"Program to run html file,to shutdown and to restart");
                this.put((Object)"file:///android_asset/prog25_6_online_shopping.html", (Object)"Online Shopping Program");
                this.put((Object)"file:///android_asset/prog25_7_medical_store.html", (Object)"Medical Store Project");
                this.put((Object)"file:///android_asset/prog25_8_authenticate_user_3_attempts.html", (Object)"Authenticating User based on 3 Attempts");
                this.put((Object)"file:///android_asset/prog25_9_atm_machine.html", (Object)"Program for ATM Machine");
                this.put((Object)"file:///android_asset/prog25_10_get_Calendar.html", (Object)"Get Calendar for Given Year and Month");
                this.put((Object)"file:///android_asset/prog25_11_money_words.html", (Object)"Print Given Money or Value in Words");
                this.put((Object)"file:///android_asset/prog25_12_compound_interest_years.html", (Object)"Program to print Compound interest for Given Years with next 4 rates in table");
                this.put((Object)"file:///android_asset/prog25_13_password_generator.html", (Object)"Password Generator");
                this.put((Object)"file:///android_asset/prog25_14_rearrange_c_code.html", (Object)"Rearrange C Code");
                this.put((Object)"file:///android_asset/prog25_15_chakravyuha.html", (Object)"Chakravyuha or Spiral Pattern Program(Question Taken from Codevitae(TCS) 2017)");
                this.put((Object)"file:///android_asset/prog25_16_generateElectricBill.html", (Object)"Caluclate Electric Bill");
                this.put((Object)"file:///android_asset/prog25_17_possi_squares_for_n_vertices.html", (Object)"Print all possible squares from given N Co-ordinates");
                this.put((Object)"file:///android_asset/prog25_18_display_file_size.html", (Object)"Display File Size");
                this.put((Object)"file:///android_asset/prog25_19_pizza_hut_management.html", (Object)"Pizza Hut Management System");
                this.put((Object)"file:///android_asset/prog25_20_num_of_days_between_dates.html", (Object)"Calculate Number of Days, Weeks and Days between 2 dates");
                this.put((Object)"file:///android_asset/prog25_21_display_date_words.html", (Object)"Display Date in Words");
                this.put((Object)"file:///android_asset/prog26_0_caesar_cipher.html", (Object)"Caesar Code Encryption");
                this.put((Object)"file:///android_asset/prog26_1_binary_cipher.html", (Object)"Binary Code Encryption");
                this.put((Object)"file:///android_asset/prog26_2_ASCII_cipher.html", (Object)"ASCII Code Encryption");
                this.put((Object)"file:///android_asset/prog26_3_morse_code.html", (Object)"Morse Code Encryption");
                this.put((Object)"file:///android_asset/prog26_4_numerial_code.html", (Object)"Numeral Code Encryption");
                this.put((Object)"file:///android_asset/prog26_5_atbash_cipher.html", (Object)"Atbash Encryption");
                this.put((Object)"file:///android_asset/prog26_6_latin_alphabet.html", (Object)"Latin Alphabet Encryption");
                this.put((Object)"file:///android_asset/prog26_7_polybius_cipher.html", (Object)"Polybius Cipher");
                this.put((Object)"file:///android_asset/prog26_8_rail_fence.html", (Object)"Rail Fence Cipher");
                this.put((Object)"file:///android_asset/prog26_9_scytale_cipher.html", (Object)"Scytale Cipher");
                this.put((Object)"file:///android_asset/prog26_10_onetimepad.html", (Object)"One Time Pad Cipher");
                this.put((Object)"file:///android_asset/prog26_11_vigenere_cipher.html", (Object)"Vigenere Cipher");
                this.put((Object)"file:///android_asset/prog26_12_affine_cipher.html", (Object)"Affine Cipher");
                this.put((Object)"file:///android_asset/prog26_13_playfair.html", (Object)"Play Fair Cipher");
                this.put((Object)"file:///android_asset/prog27_0_caesar_decrypt.html", (Object)"Caesar Code Decryption");
                this.put((Object)"file:///android_asset/prog27_1_morsecode.html", (Object)"Morse Code Decryption");
                this.put((Object)"file:///android_asset/prog27_2_railfence_decrypt.html", (Object)"Rail Fence Decryption");
                this.put((Object)"file:///android_asset/prog27_3_binary_decrypt.html", (Object)"Binary Code Decryption");
                this.put((Object)"file:///android_asset/prog27_4_atbash_decrypt.html", (Object)"Atbash Decryption");
                this.put((Object)"file:///android_asset/prog27_5_latin_decrypt.html", (Object)"Latin Alphabet Decryption");
                this.put((Object)"file:///android_asset/prog27_6_scytale_decrypt.html", (Object)"Scytale Decryption");
                this.put((Object)"file:///android_asset/prog27_7_onetimepad_decrypt.html", (Object)"One Time Pad Decryption");
                this.put((Object)"file:///android_asset/prog27_8_vigenere_decrypt.html", (Object)"Vigenere Decryption");
                this.put((Object)"file:///android_asset/prog27_9_ascii_decrypt.html", (Object)"ASCII Code Decryption");
                this.put((Object)"file:///android_asset/prog27_10_numeral_decrypt.html", (Object)"Numeral Code Decryption");
                this.put((Object)"file:///android_asset/prog27_11_affine_decrypt.html", (Object)"Affine Decipher");
                this.put((Object)"file:///android_asset/prog27_12_polybius_decrypt.html", (Object)"Polybius Decryption");
                this.put((Object)"file:///android_asset/prog_27_13_playfair.decrypt.html", (Object)"Play Fair Decryption");
                this.put((Object)"file:///android_asset/prog29_0_all_bitwise.html", (Object)"All Bitwise Operations");
                this.put((Object)"file:///android_asset/prog28_1_add_mul_bitwise.html", (Object)"Add and Mul using bitwise");
                this.put((Object)"file:///android_asset/prog28_2_odd_even_bitwise.html", (Object)"Odd or Even using bitwise");
                this.put((Object)"file:///android_asset/prog28_3_all_bits_1.html", (Object)"Check all bits of number are 1");
                this.put((Object)"file:///android_asset/display_and.html", (Object)"AND Table");
                this.put((Object)"file:///android_asset/display_or.html", (Object)"OR Table");
                this.put((Object)"file:///android_asset/display_xor.html", (Object)"XOR Table");
                this.put((Object)"file:///android_asset/prog28_7_show_bits_of_integer.html", (Object)"To show bits of Integer");
                this.put((Object)"file:///android_asset/prog28_8_swap_two_num_bitwise.html", (Object)"Swap 2 numbers using Bitwise Operators");
                this.put((Object)"file:///android_asset/comingsoon.html", (Object)"Coming Soon");
            }
        };
        if (view == null) {
            a2 = new a();
            view2 = this.inflater.inflate(2131492906, null);
            a2.programs = (TextView)view2.findViewById(2131296319);
            view2.setTag((Object)a2);
        } else {
            a a3 = (a)view.getTag();
            view2 = view;
            a2 = a3;
        }
        a2.programs.setText((CharSequence)((h)this.programslist.get(n2)).getProgramName());
        view2.setOnClickListener(new View.OnClickListener((Map)hashMap){
            final /* synthetic */ Map val$urlToProgram;
            {
                this.val$urlToProgram = map;
            }

            public void onClick(View view) {
                String string = "";
                String string2 = ((h)f.this.programslist.get(n2)).getProgramName();
                for (Map.Entry entry : this.val$urlToProgram.entrySet()) {
                    if (!string2.equals(entry.getValue())) continue;
                    string = (String)entry.getKey();
                    break;
                }
                Intent intent = new Intent(f.this.mContext, HelloWorld.class);
                intent.setData(Uri.parse((String)string));
                f.this.mContext.startActivity(intent);
            }
        });
        return view2;
    }

    public class a {
        TextView programs;
    }

}

