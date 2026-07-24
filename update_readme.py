import re
from pathlib import Path

README = Path("README.md")
content = README.read_text(encoding="utf-8")

# -----------------------------
# Count LeetCode Problems
# -----------------------------
leetcode_match = re.search(
    r"## 🟨 LeetCode(.*?)---",
    content,
    re.S
)

leetcode_count = 0
if leetcode_match:
    table = leetcode_match.group(1)
    leetcode_count = len(re.findall(r"^\|\s*\d+\s*\|", table, re.M))

# -----------------------------
# Count GFG Problems
# -----------------------------
gfg_match = re.search(
    r"## 🟦 GeeksforGeeks \(GFG\)(.*?)(?=\n#|\Z)",
    content,
    re.S
)

gfg_count = 0
if gfg_match:
    table = gfg_match.group(1)
    gfg_count = len(re.findall(r"^\|\s*\d+\s*\|", table, re.M))

total = leetcode_count + gfg_count

progress = f"""## 📈 Progress

- ✅ Total Problems Solved: **{total}**
- 🟠 LeetCode: **{leetcode_count}**
- 🟢 GeeksforGeeks: **{gfg_count}**
"""

content = re.sub(
    r"## 📈 Progress.*?---",
    progress + "\n\n---",
    content,
    flags=re.S,
)

README.write_text(content, encoding="utf-8")

print(f"Updated README: Total={total}, LC={leetcode_count}, GFG={gfg_count}")
