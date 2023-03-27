# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

# Student ID:w1830145
# Date:26/04/2021
print("-"*75)
results = [
    {
        "outcome": "Progress",
        "accept": [
            {"pass": 120, "defer": 0, "fail": 0}
        ]
    },
    {
        "outcome": "Progress (module trailer)",
        "accept": [
            {"pass": 100, "defer": 20, "fail": 0},
            {"pass": 100, "defer": 0, "fail": 20}
        ]
    },
    {
        "outcome": "Do not progress - module retriever",
        "accept": [
            {"pass": 80, "defer": 40, "fail": 0},
            {"pass": 80, "defer": 20, "fail": 20},
            {"pass": 80, "defer": 0, "fail": 40},
            {"pass": 60, "defer": 60, "fail": 0},
            {"pass": 60, "defer": 40, "fail": 20},
            {"pass": 60, "defer": 20, "fail": 40},
            {"pass": 60, "defer": 0, "fail": 60},
            {"pass": 40, "defer": 80, "fail": 0},
            {"pass": 40, "defer": 60, "fail": 20},
            {"pass": 40, "defer": 40, "fail": 40},
            {"pass": 40, "defer": 20, "fail": 60},
            {"pass": 20, "defer": 100, "fail": 0},
            {"pass": 20, "defer": 80, "fail": 20},
            {"pass": 20, "defer": 60, "fail": 40},
            {"pass": 20, "defer": 40, "fail": 60},
            {"pass": 0, "defer": 120, "fail": 0},
            {"pass": 0, "defer": 100, "fail": 20},
            {"pass": 0, "defer": 80, "fail": 40},
            {"pass": 0, "defer": 60, "fail": 60}
        ]
    },
    {
        "outcome": "Exclude",
        "accept": [
            {"pass": 40, "defer": 0, "fail": 80},
            {"pass": 20, "defer": 20, "fail": 80},
            {"pass": 20, "defer": 0, "fail": 100},
            {"pass": 0, "defer": 40, "fail": 80},
            {"pass": 0, "defer": 20, "fail": 100},
            {"pass": 0, "defer": 0, "fail": 120}
        ]
    }
]
cats = ["pass", "defer", "fail"]


def get_marks_input():
    m = {}
    for p in cats:
        while True:
            val = input(f"Please enter your credit at {p}: ")
            try:
                val = int(val)
                if val not in range(0, 121, 20):
                    print("Out of range")
                else:
                    m[p] = val
                    break
            except ValueError:
                print("Integer required")
    return m


while True:
    marks = get_marks_input()
    if sum(marks.values()) == 120:
        for r in results:
            if marks in r["accept"]:
                print(f"OUTCOME: {r['outcome']}")
                break
        break
    print("Total incorrect\n")
