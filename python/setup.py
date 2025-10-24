from setuptools import setup, find_packages

setup(
    name='maplestory_openapi',
    version='3.4.1',
    description='This Python library enables the use of the MapleStory OpenAPI of Nexon.',
    author='so99ynoodles',
    url='https://github.com/SpiralMoon/maplestory.openapi',
    long_description=open('README.md', 'r').read(),
    long_description_content_type='text/markdown',
    install_requires=[
        'requests',
        'pydantic>=2.5.3',
    ],
    packages=find_packages(),
    license='MIT',
    python_requires='>=3.9',
)
