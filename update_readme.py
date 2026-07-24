import re
from pathlib import Path

README = Path("README.md")
content = README.read_text(encoding="utf-8")

# ----------------------------
# Count LeetCode Problems
# ----------------------------
leetcode_count = 0
in_leetcode = False

# ----------------------------
# Count GFG Problems
# ----------------------------
gfg_count = 0
in_gfg = False

for line in content.splitlines():

    # Start LeetCode section
    if line.strip() == "### 🟨 LeetCode":
        in_leetcode = True
        in_gfg = False
        continue

    # Start GFG section
    if line.strip() == "### 🟦 GeeksforGeeks (GFG)":
        in_leetcode = False
        in_gfg = True
        continue

    # End GFG when next heading starts
    if line.startswith("## ") and not line.startswith("### "):
        in_leetcode = False
        in_gfg = False

    # Count LeetCode rows
    if in_leetcode:
        if re.match(r"^\|\s*\d+\s*\|", line):
            leetcode_count += 1

    # Count GFG rows
    if in_gfg:
        if re.match(r"^\|\s*\d+\s*\|", line):
            gfg_count += 1

total = leetcode_count + gfg_count

new_progress = f"""## 📈 Progress

- ✅ Total Problems Solved: **{total}**
- 🟠 LeetCode: **{leetcode_count}**
- 🟢 GeeksforGeeks: **{gfg_count}**
"""

content = re.sub(
    r"## 📈 Progress.*?---",
    new_progress + "\n\n---",
    content,
    flags=re.S,
)

README.write_text(content, encoding="utf-8")

print(f"Updated README: Total={total}, LC={leetcode_count}, GFG={gfg_count}")
