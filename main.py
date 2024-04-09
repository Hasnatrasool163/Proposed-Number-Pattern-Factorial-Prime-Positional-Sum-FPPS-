def is_prime(n):
    """Check if a number is prime."""
    if n <= 1:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def factorial(n):
    """Compute the factorial of a number."""
    if n == 0:
        return 1
    return n * factorial(n-1)

def sum_of_digits(n):
    """Sum the digits of a number."""
    return sum(int(digit) for digit in str(n))

def generate_fpps_sequence(n):
    """Generate the first n elements of the FPPS sequence."""
    sequence = []
    prime_count = 0
    num = 2  # Start checking for primes from the smallest prime number
    while prime_count < n:
        if is_prime(num):
            factorial_result = factorial(num)
            digit_sum = sum_of_digits(factorial_result)
            sequence.append(digit_sum)
            prime_count += 1
        num += 1
    return sequence

# Generate the first 10 elements of the FPPS sequence
fpps_sequence = generate_fpps_sequence(10)
print(fpps_sequence)
